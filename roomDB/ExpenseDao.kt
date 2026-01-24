package com.learn.expensetracker.data.local
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expense_db ORDER BY date DESC")
    fun getAllExpenses(): Flow<List<ExpenseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: ExpenseEntity)

    @Update
    suspend fun updateExpense(expense: ExpenseEntity)

    //partial update
    @Query("UPDATE expense_db SET amount = :amount WHERE id = :id")
    suspend fun updateAmount(id: Int, amount: Double)
    @Delete
    suspend fun deleteExpense(expense: ExpenseEntity)

    @Query("SELECT * FROM expense_db WHERE id = :id")
    suspend fun getExpenseById(id: Int): ExpenseEntity
}