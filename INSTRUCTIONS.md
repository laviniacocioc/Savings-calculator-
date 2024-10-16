Savings Calculator Implementation
In this project, I developed a savings calculator application that displays how savings will grow over 30 years based on user input for monthly savings and yearly interest rate.

User Interface
I started by implementing the user interface using a BorderPane layout. The center of the BorderPane contains a LineChart with two numerical axes (NumberAxis). At the top, I added a VBox with two BorderPanes: the first for controlling "Monthly savings" with a slider, and the second for the "Yearly interest rate," also controlled by a slider. The sliders allow the user to adjust savings between 25 and 250 euros and set the yearly interest rate between 0% and 10%. The x-axis of the chart represents years (0–30), while the y-axis dynamically adjusts to the savings values.

Displaying Savings
Next, I implemented the functionality to update the line chart based on user input. When the monthly savings amount is adjusted via the slider, the chart dynamically updates to display the savings over time. For example, if the monthly savings is set to 50 euros, the chart plots values like [(0,0), (1,600), (2,1200), (3,1800), …], reflecting the total savings growth without interest.

Displaying Savings and Interest Rate
Finally, I extended the functionality to incorporate yearly interest rates. The chart now displays two lines: one representing the growth of savings without interest, and the other showing the effect of the compounded interest. The interest is calculated yearly based on the savings at the end of each year. For instance, with 50 euros monthly savings and a 5% yearly interest rate, the chart plots values like [(0,0), (1, 630), (2, 1291.5), (3, 1986.075), …], reflecting the compound growth over time.

Additional Exploration
Upon completing the application, I explored further scenarios, such as calculating how saving 25 euros per month at a 4% yearly interest rate grows over 50 years, providing insight into long-term savings growth.

