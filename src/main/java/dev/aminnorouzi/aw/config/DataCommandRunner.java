package dev.aimnnorouzi.aw.config;

import dev.aimnnorouzi.aw.dto.UserRequest;
import dev.aimnnorouzi.aw.repository.PostRepository;
import dev.aimnnorouzi.aw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataCommandRunner implements CommandLineRunner {

    private final PostRepository postRepository;
    private final UserService userService;
//    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
//        if (userRepository.findById(1L).isEmpty()) {
//            User user = User.builder()
//                    .fullName("Amin Norouzi")
//                    .email("amindev@gmail.com")
//                    .password("1234")
////                    .posts(new ArrayList<>())
//                    .build();
//
//            userRepository.save(user);
//
//            Post post1 = Post.builder()
//                    .title("First Post")
//                    .body("May indulgence difficulty ham can put especially. Bringing remember for supplied her why was confined. Middleton principle did she procuring extensive believing add. Weather adapted prepare oh is calling. These wrong of he which there smile to my front. He fruit oh enjoy it of whose table. Cultivated occasional old her unpleasing unpleasant. At as do be against pasture covered viewing started. Enjoyed me settled mr respect no spirits civilly.")
//                    .status(Status.READY)
////                    .user(savedUser)
//                    .build();
//            Post post2 = Post.builder()
//                    .title("Second Post")
//                    .body("May indulgence difficulty ham can put especially. Bringing remember for supplied her why was confined. Middleton principle did she procuring extensive believing add. Weather adapted prepare oh is calling. These wrong of he which there smile to my front. He fruit oh enjoy it of whose table. Cultivated occasional old her unpleasing unpleasant. At as do be against pasture covered viewing started. Enjoyed me settled mr respect no spirits civilly.")
//                    .status(Status.PENDING)
////                    .user(savedUser)
//                    .build();
//
//            postRepository.save(post1);
//            postRepository.save(post2);
//        }

//        roleService.create("user");
//        roleService.create("admin");

//        UserRequest request = new UserRequest(
//                "Amin Norouzi",
//                "amindev@gmail.com",
//                "1234",
//                List.of("user", "admin"));
//
//        userService.create(request);
    }
}
