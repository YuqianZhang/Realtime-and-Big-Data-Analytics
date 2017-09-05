README info:
There are 5 folders when you unzip the the code file:
1. originalsourcedata 
2. cleandata
3. analyzecode
4. result
5. summary

----------------------folder detail----------------------
1. originalsourcedata:
Basically stores the original data set taken from imdb, movie_metadata.csv. And a data_schema.txt as well. 

2. cleandata:
includes 3 sub-folders:
	-1)DataCleanCode://they are also available in NYU HPC Cluster under my dumbo account: yz2444 and yz2444/class7
		includes all java, class and jar producedand used in the MapReduce job
	-2)MapReduceResult:
		only includes the result of my data cleaning MapReduce code: part-r-00000
	-3)convert2csv:
		includes converted ready-to-use movie_medata.csv with another copy of with head column 

3. analyzecode:
I saved all my sql commands in analyzecode.sql 

4. result:
They are csv files and screenshots of the result of my sql commands from previous folder. 

5. summary:
They are summaries (in order):
movie gross driven genres summary
imdbscore driven genres summary
imdbscore adjusted driven genres summary
movie facebook likes individually driven genres summary
total cast member facebook likes individually driven genres summary
actors facebook likes individually driven genres summary
director facebook likes individually driven genres summary
combination1: actor + director facebook likes driven genres summary
combiantion2: movie + total cast member facebook likes driven genres summary
combiantion3: total facebook likes factors summary 
There is a comparasion sheet and a screenshot of it in this folder as well. It shows which combination is more perfectly match with the gross result.