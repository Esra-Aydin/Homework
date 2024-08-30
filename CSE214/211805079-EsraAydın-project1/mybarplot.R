file <- read.table(file="DatasetNA.txt",header = TRUE)
#question 1.a
my_barplot <- function(main_title="Gender Barplot",
                       x_label="Gender",y_label="Count",
                       x_limits=NULL,y_limits=NULL,
                       colors=c("pink", "blue")){
  
  #calculate female and male number
  female_count<-sum(file$Gender=="Female")
  cat("Female: ",female_count,"\n")
  male_count<-sum(file$Gender=="Male")
  cat("Male: ",male_count,"\n")
  
  #create plot
  plot(1 ,type="n" ,main=main_title ,xaxt="n",
       axes=FALSE ,xlab=x_label ,ylab=y_label,
       xlim=c(0,2) ,ylim = c(0, max(female_count , male_count)))
  axis(2)
  
  #draw and paint
  polygon(x=c(0.2, 0.2, 0.6, 0.6) ,y=c(0, female_count ,female_count, 0) ,
          col=colors[1] , xlim=x_limits ,ylim=y_limits ,border=NA)
  polygon(x=c(1, 1, 1.4, 1.4) , y=c(0, male_count, male_count, 0) ,
          col=colors[2] ,xlim=x_limits ,ylim=y_limits ,border=NA)
  
  axis(1 ,at = c(0.4, 1.2) ,labels = c("Female","Male") ,tcl=0 ,col = "white")
  
}
my_barplot(main_title = "Gender Distribution", 
           x_label = "Gender" ,y_label = "Frequency")


#question 1.b
group_plot<-function(main_title="Group Barplot",
                      x_label="Group",y_label="Count",
                      x_limits=NULL,y_limits=NULL,
                      colors=c("pink","red","green", "blue")){
  
  group1_count <- sum(dosya$Group=="Group1")
  cat("group1 is: ",group1_count,"\n")
  group2_count <- sum(dosya$Group=="Group2")
  cat("group2 is: ",group2_count,"\n")
  group3_count <- sum(dosya$Group=="Group3")
  cat("group3 is: ",group3_count,"\n")
  group4_count <- sum(dosya$Group=="Group4")
  cat("group4 is: ",group4_count,"\n")
  
  plot(1,type="n",main="Groups",axes=FALSE,xlab="",ylab="",
       xlim=c(1,14),ylim = c(0, max(group1_count, group2_count,group3_count,group4_count)))
  axis(2)
  
  polygon(x=c(1, 1, 2.5, 2.5), y=c(0, group1_count, group1_count, 0),
          col=colors[1] , border=NA)
  polygon(x=c(4, 4, 6, 6), y=c(0, group2_count, group2_count, 0),
          col=colors[2] , border=NA)
  polygon(x=c(8, 8, 10, 10), y=c(0, group3_count, group3_count, 0),
          col=colors[3] , border=NA)
  polygon(x=c(12, 12, 14, 14), y=c(0, group4_count, group4_count, 0),
          col=colors[4] , border=NA)
  
  axis(1, at = c(1.75,5,9,13),labels = c("Group1" ,"Group2" ,"Group3" ,"Group4" ),tcl=0,col = "white")
  
}
group_plot(main_title="Group Barplot",
           x_label="Group",y_label="Frequency")

#question 1.c
two_categorical<-function(){
  par(mfrow = c(1, 2))  # Setup the plotting area
  
  my_barplot(main_title="Gender Distribution",
             x_label="Gender", y_label="Frequency")
  group_plot(main_title="Group Distribution",
             x_label="Group", y_label="Frequency")
}
print(two_categorical())
