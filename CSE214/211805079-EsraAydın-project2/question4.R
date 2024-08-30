file <- read.table(file="DatasetNA.txt",header = TRUE)

#question 4
#calculate  variable or variables
my_scale <- function(vars){
  
  scale_function <- function(x){
    mean_x <- mean(x,na.rm = TRUE)
    sum_of_square <- sum((x-mean_x)^2,na.rm = TRUE)
    standard_deviation <- sqrt(sum_of_square/(length(x)-1))
    scaled_var <- (x - mean_x) / standard_deviation
    return(scaled_var)
  }
  
  # Apply the scaling function to specified columns
  scaled_df <- file
  scaled_df[vars] <- lapply(file[vars],scale_function)
  scaled_data <- scaled_df[vars]
  return(scaled_data)
}
option <- names(file)
choice <- menu(option, title = "Choose variables")
choice2 <- menu(option, title = "choose second variable or (0 to skip that step)")

if (choice != 0) {
  selected_variable <- option[choice]
  if(choice2 != 0){
    selected_variable2 <- option[choice2]
    result <- my_scale(vars = c(selected_variable,selected_variable2))
  }else{
    result <- my_scale(vars = c(selected_variable))
  }
  print(result)
}

