package be.pxl.demo.api.dto;

import java.util.List;

public record PostDTO(String title, List<String> review) {
}
