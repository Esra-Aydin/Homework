file <- read.table(file="DatasetNA.txt",header = TRUE)

# question 1
#(ready-made functions were not used)

my_function<- function(variable1,variable2=NULL){
  
  #removing NA from DATASET
  dataset <- na.omit(file[[variable1]])
  #length dataset = number of observation
  cat("number of observation:",length(dataset))
  
  #using quantile for min,max and median
  r <- quantile(dataset,c(0,0.5,1))
  cat("\nmin is: ",r[1],"\nmedian is: ",r[2],"\nmax is: ",r[3],"\nrange is: ",r[3]-r[1])
  
  #this part calculate mean ,sum of squares then calculate variance and standard_deviation
  sum_x <- sum(dataset)
  mean_val <- mean(dataset)
  sum_of_square <- sum((dataset - mean_val)^2)
  variance <- sum_of_square / (length(dataset) - 1)
  standard_deviation <- sqrt(variance)
  
  cat("\nsum is: ",sum_x)
  cat("\nmean is: ",mean_val)
  cat("\nsum of square is: ",sum_of_square)
  cat("\nvariance is: ",variance)
  cat("\nstandart deviation is: ", standard_deviation)
  
  #******calculate Cross-products,   Covariance   Correlations******
  
  if(!is.null(variable2)){
    dataset2 <- na.omit(file[[variable2]])
  
  #it must be of the same length to calculate
  if (length(dataset) != length(dataset2)) {
    stop("Variables must have the same length")
  }
  
  mean_val2 <- mean(dataset2)
  sum_of_square2 <- sum((dataset2 - mean_val2) ^ 2)
  cross_product <- sum((dataset - mean_val)*(dataset2 - mean_val2))

  # cross_product divided by length dataset - 1 = coveriance
  covariance <- cross_product / (length(dataset) - 1)
 
  #correlation_coefficient => coveriance divided by standart deviation  first variable * standart deviation second variable
  correlation_coefficient <- covariance / (sqrt(sum_of_square/length(dataset - 1 )) * 
                                             sqrt(sum_of_square2/length(dataset - 1)))
  
  cat("\ncross-product is: ",cross_product)
  cat("\ncoveriance is: ",covariance)
  cat("\ncorrelation_coefficient is: ", correlation_coefficient)
  }
}

#option for where variable calculate the entire step
option <- c("var1","var2","var3","var4","var5","var6","var7","var8")
choice1<-menu(option,title = "choose a first varible")
choice2<-menu(option,title = "choose a second varible for Cross-products,  
Covariance and Correlations or (0 exit)")

if(choice!=0){
  selected_variable1 <- paste("Var",choice1,sep="")
  
  if(choice2!=0){
    selected_variable2 <- paste("Var", choice2, sep="")
    my_function(selected_variable1, selected_variable2)
  }else{
    my_function(selected_variable1)
  }
 
}
