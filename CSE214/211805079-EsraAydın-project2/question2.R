file <- read.table(file="DatasetNA.txt",header = TRUE)

#question 2
#there is also a solution to the first question
select_dataset <- function(variable, group=NULL, gender=NULL) {
  if (!is.null(group) & !is.null(gender)) {
    return(na.omit(file[file$Group == group & file$Gender == gender, variable]))
  } else if (!is.null(group)) {
    return(na.omit(file[file$Group == group, variable]))
  } else if (!is.null(gender)) {
    return(na.omit(file[file$Gender == gender, variable]))
  } else {
    return(na.omit(file[, variable]))
  }
}

# Main function to compute statistics and correlations
my_function <- function(variable, variable2=NULL, group=NULL, gender=NULL) {
  
  dataset <- select_dataset(variable, group, gender)
  
  length_data <- length(dataset)
  r <- quantile(dataset,c(0,0.5,1))
  sum_data <- sum(dataset)
  mean_val <- mean(dataset)
  sum_of_square <- sum((dataset - mean_val)^2)
  variance <- sum_of_square / (length_data - 1)
  standard_deviation <- sqrt(variance)
  
  cat("Number of observations:", length_data, "\n")
  cat("Min:", r[1], "\nMedian:", r[2], "\nMax:", r[3], "\nRange:", r[3] - r[1], "\n")
  cat("Sum:", sum_data, "\nMean:", mean_val, "\nSum of squares:", sum_of_square, "\n")
  cat("Variance:", variance, "\nStandard deviation:", standard_deviation, "\n")
  
  if (!is.null(variable2)) {
    dataset2 <- select_dataset(variable2, group, gender)
    
    # Check if both datasets have the same length
    if (length(dataset) != length(dataset2)) {
      stop("Variables must have the same length")
    }
    
    mean_val2 <- mean(dataset2)
    sum_of_square2 <- sum((dataset2 - mean_val2) ^ 2)
    cross_product <- sum((dataset - mean_val)*(dataset2 - mean_val2))
    covariance <- cross_product / (length(dataset2) - 1)
    correlation_coefficient <- covariance / (sqrt(sum_of_square/length(dataset - 1 )) * 
                                               sqrt(sum_of_square2/length(dataset - 1)))
    
    cat("\ncross-product is: ",cross_product)
    cat("\ncoveriance is: ",covariance)
    cat("\ncorrelation_coefficient is: ", correlation_coefficient)
  }
}

# Menu for choosing variables
option <- c("Var1", "Var2", "Var3", "Var4", "Var5", "Var6", "Var7", "Var8")
choice1 <- menu(option, title = "Choose the first variable")
choice2 <- menu(option, title = "Choose a second variable for Cross-products,  
Covariance and Correlations or (0 to skip)")

if (choice1 != 0) {
  selected_variable <- option[choice1]
  selected_variable2 <- if (choice2 != 0) option[choice2] else NULL
  
  selected_group <- readline(prompt = "Enter a group (Group1, Group2, Group3, Group4) or leave blank for None:")
  selected_group <- if (selected_group == "") NULL else selected_group
  
  selected_gender <- readline(prompt = "Enter a gender (Male, Female) or leave blank for None:")
  selected_gender <- if (selected_gender == "") NULL else selected_gender
  
  my_function(selected_variable, selected_variable2, group=selected_group, gender=selected_gender)
}
