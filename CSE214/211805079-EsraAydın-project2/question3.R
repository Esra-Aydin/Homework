file <- read.table(file="DatasetNA.txt",header = TRUE)

# draw scatterplot between two variables or draw scatterplot-matrix among variables in a data frame 
my.scatterplot.matrix <- function(variables) {
  
  selected_data <- na.omit(file[variables])
  num_vars <- length(variables)
  
  if(num_vars==2){
    
    x <- selected_data[[variables[1]]]
    y <- selected_data[[variables[2]]]
    
    plot(x,y,
         main = paste("Scatterplot:",variables[1],"vs",variables[2]),
         xlab=variables[1],
         ylab=variables[2],
         pch = 16 , col ="blue")
  }else{
    
  par(mfrow=c(num_vars ,num_vars ),mar=c(3,3,3,3))
    
  for (i in 1:num_vars) {
      for (j in  1:num_vars) {
        if(i==j){
          plot(1,1,xaxt="n",yaxt="n",
               xlab = "", ylab = "", main=paste(variables[i]))
        }else{
          plot(selected_data[[j]],selected_data[[i]],
               xlab=variables[j],
               ylab=variables[i],
               main=paste(variables[i]," vs ",variables[j]),
               cex=0.5,pch=19)
        }
      }  
    }
  }
  par(mfrow = c(1, 1))#make default
}

#if select two variables draw scatterplot between two variables
#if select more than two variables draw scatterplot-matrix
option <- c("var1", "var2", "var3", "var4", "var5", "var6", "var7", "var8")
choices <- numeric(0)

while(TRUE){
  choice <- menu(option, title = "Choose more than two variable (0 to exit)")
  if (choice == 0)break
  else choices <- c(choices, choice)
}

selected_variables <- paste("Var", choices, sep ="")
my.scatterplot.matrix(selected_variables)
