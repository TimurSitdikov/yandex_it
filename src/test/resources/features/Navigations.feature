@Navigation
  Feature: Tests that check correct site navigation

    @NavigationMainTabs
    Scenario: Check reaction of navigation buttons and links on main page
      Given User opens main yandex realty page
      Then User checks that type switch works correctly