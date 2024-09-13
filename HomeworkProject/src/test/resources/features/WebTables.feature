Feature:Web Table page
  As a user, I add a new row to the web table, and later, I edit it

  Scenario:Adding and editing a new row in the web table
    Given User is on the Web Tables page
    When User clicks 'addbtn' button
    And User fills in the form with the following details

      | firstName | lastName | email       | age | salary | department |
      | Ayse      | Yilmaz   | xxx@mail.co |25   |30000   |IT          |

    And User clicks 'Edit' button
    And User edits the first name to 'Merve'
    Then New row's first column should display 'Merve'