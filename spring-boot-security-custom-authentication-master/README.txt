UserDetailsService
------------------
The UserDetailsService interface is used to retrieve user-related data. 
It has one method named loadUserByUsername() which can be overridden to customize the 
process of finding the user.

It is used by the DaoAuthenticationProvider to load details about the user during authentication.

You can also simply prefix {noop} to your passwords in order for the DelegatingPasswordEncoder
 use the NoOpPasswordEncoder to validate these passwords. 
 Notice that NoOpPasswordEncoder is deprecated though, 
 as it is not a good practice to store passwords in plain text.

User.withUsername("user").password("{noop}user").roles("USER").build();