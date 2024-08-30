file <- read.table(file="DatasetNA.txt",header = TRUE)
#question 2.a.b
myHistogram <- function(var_name,bins=20,main_title="Histogram",
                        x_label="X-axis",y_label="Frequency",
                        x_limits=NULL,y_limits=NULL,color="pink"){

  var_data <- file[[var_name]]
  
  if(!is.numeric(var_data)){
    stop("variable is not continuous")
  }
  
  #calculate the histogram breaks
  min_val <- min(var_data,na.rm = TRUE)
  max_val <- max(var_data,na.rm = TRUE)
  breaks <- seq(min_val,max_val,length.out=bins + 1)
  
  #calculate counts for each bin
  counts <- hist(var_data,breaks,plot=FALSE)$counts
  
  if (is.null(x_limits)) {
    x_limits <- c(min_val, max_val)
  }
  if (is.null(y_limits)) {
    y_limits <- c(0, max(counts))
  }
  
  #create a plot
  plot(1,type="n",main=main_title,xlab=x_label,ylab=y_label,
       xlim=x_limits,
       ylim=y_limits,
       xaxt="n",yaxt="n",bty="n")
  
  #draw the histogram bars
  for(i in 1:length(counts)){
    polygon(x=c(breaks[i],breaks[i],breaks[i+1],breaks[i+1]),
            y=c(0,counts[i],counts[i],0),
            col=color,border="black")
  }
  
  axis(1,at=seq(min_val,max_val,length.out=bins + 1))
  axis(2)
  
}
myHistogram(var_name="Var1",bins = 10, main_title = "Histogram of Var", 
            x_label = "Var1", y_label = "Frequency", color = "green")


#question 2.c
more_histogram <- function(vars){
  par(mfrow=c(1,length(vars)))
  for(var in vars ){
    if(!var %in% names(data)){
      cat("Variable ",var, " not found.")
      next
    }
    myHistogram(var_name = var,bins = 10, main_title =  paste("Histogram of", var), 
                x_label = var, y_label = "Frequency", color = "green")
  }
}
more_histogram(vars = c("Var1","Var2","Var3"))
