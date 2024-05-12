//package ProjectDemo.demo.ConfigSecurity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//    @Autowired
//    CustomSuccessHandler customSuccessHandler;
//
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/admin_home","/registration").permitAll()
////                        .anyRequest().authenticated())
////                .httpBasic(Customizer.withDefaults())
////                .formLogin(customizer -> customizer
////                                .loginPage("/login")
////
////                        .permitAll()
////                               // .defaultSuccessUrl("/home", true)
////
////                )
////                .csrf(AbstractHttpConfigurer::disable);
////        return http.build();
////    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(c -> c.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/admin_home").hasAuthority("ADMIN")
//                        .requestMatchers("/home").hasAuthority("USER")
//                        .requestMatchers("/registration","table_user", "/css/**").permitAll()
//                        .anyRequest().authenticated())
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .loginProcessingUrl("/login")
//                        .passwordParameter("password")
//                        .usernameParameter("email")
//                        .successHandler(customSuccessHandler)
//                        .permitAll())
//                .logout(logout -> logout
//                        .invalidateHttpSession(true)
//                        .clearAuthentication(true)
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessUrl("/login?logout")
//                        .permitAll())
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) // Chính sách tạo session
//                        .maximumSessions(1) // Số lượng session tối đa cho mỗi người dùng
//                        .expiredUrl("/login?expired")); // URL chuyển hướng khi session hết hạn
//
//        return http.build();
//    }
////@Bean
////public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////    http.csrf().disable()
////            .authorizeHttpRequests((authorize) ->
////                    authorize.requestMatchers("/registration/**").permitAll()
////                         //   .requestMatchers("/index").permitAll()
////                            .requestMatchers("/users").hasRole("ADMIN")
////            ).formLogin(
////                    form -> form
////                            .loginPage("/login")
////                            .loginProcessingUrl("/login")
////                            .defaultSuccessUrl("/users")
////                            .permitAll()
////            ).logout(
////                    logout -> logout
////                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                            .permitAll()
////            );
////    return http.build();
////}
//
//
//
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new UserInfoUserDetailsService();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        return daoAuthenticationProvider;
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
