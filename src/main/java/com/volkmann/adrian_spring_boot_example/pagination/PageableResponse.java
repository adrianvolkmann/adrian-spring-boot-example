package com.volkmann.adrian_spring_boot_example.pagination;

import java.util.List;

public record PageableResponse(List<?> content, //
							   int pageNumber, //
							   int pageSize, //
							   int numberOfElements, //
							   int totalPages, //
		                       long totalElements) {
}
