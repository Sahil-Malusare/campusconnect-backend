package campusconnect.backend.vendor;

import campusconnect.backend.entity.User;
import campusconnect.backend.entity.Vendor;
import campusconnect.backend.entity.VerificationStatus;
import campusconnect.backend.repository.UserRepository;
import campusconnect.backend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class Controller {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private VendorRepository vendorRepo;

    @PostMapping("/register")
    public String register(@RequestBody VendorProfileRequest request,
                           Authentication authentication)
    {
        String email = authentication.getName();

        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("user not found"));

        Vendor vendor = Vendor.builder()
                .businessName(request.getBusinessName())
                .category(request.getCategory())
                .phone(request.getPhone())
                .gstNumber(request.getGstNumber())
                .businessLicenseUrl(request.getBusinessLicenseUrl())
                .verificationStatus(VerificationStatus.PENDING)
                .user(user)
                .build();

        vendorRepo.save(vendor);

        return "vendor register successfully";
    }

}
