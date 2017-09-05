inputText = LOAD 'input.txt' USING PigStorage('-') AS (timestamp:chararray,name:chararray,tweet:chararray);
tokens = FOREACH inputText GENERATE $0, CONCAT(name,' ',tweet) as tweetcontext;
tokens = FOREACH tokens GENERATE $0, TOKENIZE (LOWER (tweetcontext), ';,:#- /') AS word;
tokens = FOREACH tokens GENERATE $0, FLATTEN(word);
tokens = DISTINCT tokens;
tokens = FOREACH tokens GENERATE $1;

searchText = LOAD 'search.txt';
searchWords = FOREACH searchText GENERATE LOWER((chararray)$0) ;

filteredData = JOIN searchWords BY $0 LEFT OUTER, tokens BY $0;
wordCount =FOREACH filteredData GENERATE $0,($1 is null ? 0:1);
groupData = GROUP wordCount BY $0;
result = FOREACH groupData GENERATE group, SUM(wordCount.$1);

DUMP result;
STORE result INTO 'result';


