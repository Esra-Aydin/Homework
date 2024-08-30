file <- read.table(file = "DatasetNA.txt",header = TRUE)

#question 3.a.b
my_boxplot <- function(variable,main_title = "my boxplot", x_label = "Variable",
                       y_label = "Value", x_limits = y, y_limits = c(r[1],r[5]),
                       box_color="green",line_color = "green", median_color = "green"){
  #for remove NA value
  dataset <- na.omit(variable)
  #getting the values(median , quarter, min and max value)
  r <- quantile(dataset,c(0,0.25,0.5,0.75,1))
  
  cat("quarter1: ",r[2],"\nmedian: ",r[3],"\nquarter3: ",r[4])
  
  y <- 1:length(dataset)
  plot(y ,type="n",xaxt="n", ylim = y_limits, xlab = x_label, ylab = y_label, main = main_title)
  axis(2)
  
  #for drawing box which is quantile
  lines(c(40, 40), c(r[2],r[4]), lwd = 2,col= line_color )
  lines(c(40, 60), c(r[2],r[2]), lwd = 2,col= line_color)
  lines(c(40, 60), c(r[4],r[4]), lwd = 2,col= line_color)
  lines(c(60, 60), c(r[2],r[4]), lwd = 2,col= line_color)
  
  #painting box
  polygon(c(40, 40, 60, 60), c(r[2], r[4], r[4], r[2]), col = box_color, border = NA)
  #line for median
  lines(c(40,60),c(r[3],r[3]),lwd=2,col= median_color)
  
  #horizantel line for min value to quarter1 (0 to 0.25)
  segments(x0 = 35, y0 = r[1], x1 = 65, y1 = r[1], lty = 1, lwd = 2) 
  segments(x0 = 35, y0 = r[5], x1 = 65, y1 = r[5], lty = 1, lwd = 2)
  #vertical line for values that going to max value(0.75 to 1)
  segments(x0 = 50, y0 = r[1], x1 =50, y1 = r[2], lty = 2, lwd = 2) 
  segments(x0 = 50, y0 = r[4], x1 = 50, y1 = r[5], lty = 2, lwd = 2)
} 
#option- choice for user select which variable want
option <- c("var1","var2","var3","var4","var5","var6","var7","var8")
choice <- menu(option,title = "choose a variable(0 exit)")
if (choice != 0) {
  selected_variable <- paste("Var", choice, sep = "")
  my_boxplot(file[[selected_variable]],main_title = paste("Boxplot of ",selected_variable),
             x_label = "Variable",y_label = "Value",
             box_color="grey",line_color = "black", median_color = "blue")
}


#question 3.c
more_boxplot <- function(vars) {
  
  par(mfrow = c(1, length(vars)))  # Set up multiple plots in one output
  
  for (variable in vars) {
    cat("\n****quarter for",variable,"****\n")
    my_boxplot(file[[variable]],main_title = paste("Boxplot of ",variable),
               x_label = paste(variable),y_label = "Value",
               box_color="grey",line_color = "black", median_color = "blue")
   
  }
}
more_boxplot(vars=c("Var1","Var4","Var8"))


dev.off()#cleaning the plots
#question 3.d
boxplot_gender <- function(variable, main_title = "Boxplot Based on Gender", x_label = "Gender",y_label = "Value",
                        x_limits = y, y_limits=c(min(c(male_quart[1],female_quart[1])),max(c(male_quart[5],female_quart[5]))),
                        line_color = "black",median_color = "blue"){
  
  # Subset data based on gender
  male_data <- file[file$Gender == "Male",variable]
  male_data <- na.omit(male_data)
  female_data <- file[file$Gender == "Female",variable]
  female_data <- na.omit(female_data)
  
  # Calculate quartiles for both genders
  male_quart <- quantile(male_data, c(0, 0.25, 0.5, 0.75, 1))
  female_quart <- quantile(female_data, c(0, 0.25, 0.5, 0.75, 1))
  
  cat("Male - quarter1: ", male_quart[2], "\nMale - median: ", male_quart[3], "\nMale - quarter3: ", male_quart[4], "\n")
  cat("Female - quarter1: ", female_quart[2], "\nFemale - median: ",
      female_quart[3],"\nFemale - quarter3: ", female_quart[4], "\n")
  y <- 1:length(male_data)
  
  # Set up the plot
  plot(y, type = "n",xaxt="n", ylim = y_limits, xlab = x_label, ylab = y_label, main = main_title)
  axis(2)
  axis(1,at=c(15,35),labels=c("Male","Female"),tcl=0)
  
  #for male
  lines(c(10, 10), c(male_quart[2], male_quart[4]), lwd = 2, col = line_color)
  lines(c(10, 20), c(male_quart[2], male_quart[2]), lwd = 2, col = line_color)
  lines(c(10, 20), c(male_quart[4], male_quart[4]), lwd = 2, col = line_color)
  lines(c(20, 20), c(male_quart[2], male_quart[4]), lwd = 2, col = line_color)
  # Median line
  lines(c(10, 20), c(male_quart[3], male_quart[3]), lwd = 2, col = median_color)
  # Horizontal lines
  segments(x0 = 5, y0 = male_quart[1], x1 = 25, y1 = male_quart[1], lty = 1, lwd = 2)
  segments(x0 = 5, y0 = male_quart[5], x1 = 25, y1 = male_quart[5], lty = 1, lwd = 2)
  # Vertical lines
  segments(x0 = 15, y0 = male_quart[1], x1 = 15, y1 = male_quart[2], lty = 2, lwd = 2)
  segments(x0 = 15, y0 = male_quart[4], x1 = 15, y1 = male_quart[5], lty = 2, lwd = 2)
  
  #for female
  lines(c(30, 30), c(female_quart[2], female_quart[4]), lwd = 2, col = line_color)
  lines(c(30, 40), c(female_quart[2], female_quart[2]), lwd = 2, col = line_color)
  lines(c(30, 40), c(female_quart[4], female_quart[4]), lwd = 2, col = line_color)
  lines(c(40, 40), c(female_quart[2], female_quart[4]), lwd = 2, col = line_color)
  # Median line
  lines(c(30, 40), c(female_quart[3], female_quart[3]), lwd = 2, col = median_color)
  # Horizontal lines
  segments(x0 = 27, y0 = female_quart[1], x1 = 45, y1 = female_quart[1], lty = 1, lwd = 2)
  segments(x0 = 27, y0 = female_quart[5], x1 = 45, y1 = female_quart[5], lty = 1, lwd = 2)
  # Vertical lines
  segments(x0 = 35, y0 = female_quart[1], x1 = 35, y1 = female_quart[2], lty = 2, lwd = 2)
  segments(x0 = 35, y0 = female_quart[4], x1 = 35, y1 = female_quart[5], lty = 2, lwd = 2)
}

option <- c("var1","var2","var3","var4","var5","var6","var7","var8")
choice <- menu(option,title = "choose a variable(0 exit)")
if (choice != 0) {
  boxplot_gender(paste("Var", choice, sep = ""))
}
