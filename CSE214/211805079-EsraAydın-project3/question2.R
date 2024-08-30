file <- read.table(file="MultRegData.txt",header = TRUE)

#question2
my_solution <- function(response_var) {
  Y <- file[[response_var]]
  
  # Get all predictor variables
  predictors <- setdiff(names(file), response_var)
  
  # Helper function to calculate model statistics
  calculate_model_stats <- function(predictors_subset) {
    
    X <- as.matrix(file[predictors_subset])
    B0 <- matrix(1, nrow = nrow(X), ncol = 1)
    x_matrix <- cbind(B0, X)
    
    # Calculate coefficients
    x_matrix_transpose <- t(x_matrix)
    x_transpose_y <- x_matrix_transpose %*% Y
    x_transpose_x <- x_matrix_transpose %*% x_matrix
    least_square_esti <- solve(x_transpose_x) %*% x_transpose_y
    
    # Estimates of y and residuals
    estimates_y <- x_matrix %*% least_square_esti
    estimated_residuals <- Y - estimates_y
    
    # Calculate TSS, RMSS, RSS, and R-squared
    TSS <- sum((Y - mean(Y))^2)
    RSS <- sum(estimated_residuals^2)
    RMSS <- TSS - RSS
    R_squared <- RMSS / TSS
    
    return(list(
      model = paste(predictors_subset, collapse = " + "),
      TSS = TSS,
      RMSS = RMSS,
      RSS = RSS,
      R_squared = R_squared
    ))
}
  
  # Get all possible combinations of predictor variables
  all_combinations <- unlist(lapply(1:length(predictors), function(x) {
    combn(predictors, x, simplify = FALSE)
  }), recursive = FALSE)
  
  # Calculate statistics for each model
  results <- lapply(all_combinations, calculate_model_stats)
  
  # Convert results to data frame
  results_df <- do.call(rbind, lapply(results, as.data.frame))
  
  # Order results by R-squared in descending order
  results_df <- results_df[order(-results_df$R_squared),]
  
  return(results_df)
}

# Create a hypothetical dataset
set.seed(123)
file <- data.frame(
  Y = rnorm(length(file$Y)),
  X1 = rnorm(length(file$X1)),
  X2 = rnorm(length(file$X2)),
  X3 = rnorm(length(file$X3)),
  X4 = rnorm(length(file$X4)),
  X5 = rnorm(length(file$X5)),
  X6 = rnorm(length(file$X6)),
  X7 = rnorm(length(file$X7))
)
result <- my_solution("Y")
print(result)
