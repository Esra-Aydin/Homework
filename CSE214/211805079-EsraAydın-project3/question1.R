file <- read.table(file="MultRegData.txt",header = TRUE)

#question 1
my_solution <- function(selected_var){
 
  #make matrix form
  X <- as.matrix(file[selected_var])
  Y <- file$Y

  #combine 1,...1(for B0) with select X variable 
  B0 <- matrix(c(1),length(Y),1)
  x_matrix <- cbind(B0,X)
  n <- ncol(x_matrix)
  
  #calculate B0,B1,...(for which and how many variable select )
  x_matrix_transpoze <- t(x_matrix)
  x_transpoz_y <- (x_matrix_transpoze %*% Y) 
  x_transpoz_x <- (x_matrix_transpoze %*% x_matrix) 
  least_square_esti <- solve(x_transpoz_x) %*% x_transpoz_y
  
  for (i in 1:n) {
    #begin with B0 and calculate regression coefficients in which order they selected 
    cat("\nB",(i - 1),": ", least_square_esti[i])
  }
  
  #calculate estimates of y and e
  estimates_y <- x_matrix %*% least_square_esti
  estimated_residuals <- (Y - estimates_y)
  
  cat("\nEstimates of y: ")
  print(estimates_y)
  cat("\nEstimates of residuals e: ")
  print(estimated_residuals)
 
  #calculate TTS,RMSS,RSS and cofficient of determination
  TSS <- t(Y) %*% Y - (t(B0) %*% Y )^2 / length(Y)
  cat("\nTSS: ",TSS) 
  
  #RMSS
  RMSS <- t( estimates_y) %*%  estimates_y - (t(B0) %*% estimates_y )^2 / length(Y)
  cat("\nRMSS: ",RMSS)
 
  #RSS
  RSS <- t(estimated_residuals) %*% estimated_residuals
  cat("\nRSS: ",RSS)
  
  #R^2 =RMSS / TSS
  r_square <- RMSS / TSS
  cat("\nR square: ",r_square)
}

#user select variable or variables to calculate simple or multiple regression
option <- c("X1","X2","X3","X4","X5","X6","X7")
selected_vars <- character(0)
repeat {
  choice <- menu(option, title = "Choose variable for simple or multiple regression (0 to exit)")
  
  if (choice == 0) break
  selected_vars <- c(selected_vars, option[choice])
}
my_solution( selected_vars)
