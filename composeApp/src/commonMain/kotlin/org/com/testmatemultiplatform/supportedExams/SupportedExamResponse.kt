package org.com.testmatemultiplatform.supportedExams

data class SupportedExamResponse(
    val id: Long,
    val examName: String?,
    val imageUrl: String?,
    val subCategory: List<ExamSubCategoryResponse>? = null
)

data class ExamSubCategoryResponse(val id: Long, val subCategory: String?, val imageUrl: String?)

val mockSupportedExamResponses = listOf(
    SupportedExamResponse(
        id = 1L,
        examName = "Mock Exam 1",
        imageUrl = "https://example.com/exam1-image.png",
        subCategory = listOf(
            ExamSubCategoryResponse(
                id = 101L,
                subCategory = "Sub Category 1.1",
                imageUrl = "https://example.com/sub-category-1-1.png"
            ),
            ExamSubCategoryResponse(
                id = 102L,
                subCategory = "Sub Category 1.2",
                imageUrl = "https://example.com/sub-category-1-2.png"
            )
        )
    ),
    SupportedExamResponse(
        id = 2L,
        examName = "Mock Exam 2",
        imageUrl = "https://example.com/exam2-image.png",
        subCategory = listOf(
            ExamSubCategoryResponse(
                id = 201L,
                subCategory = "Sub Category 2.1",
                imageUrl = "https://example.com/sub-category-2-1.png"
            ),
            ExamSubCategoryResponse(
                id = 202L,
                subCategory = "Sub Category 2.2",
                imageUrl = "https://example.com/sub-category-2-2.png"
            )
        )
    ),
    SupportedExamResponse(
        id = 3L,
        examName = "Mock Exam 3",
        imageUrl = "https://example.com/exam3-image.png",
        subCategory = listOf(
            ExamSubCategoryResponse(
                id = 301L,
                subCategory = "Sub Category 3.1",
                imageUrl = "https://example.com/sub-category-3-1.png"
            ),
            ExamSubCategoryResponse(
                id = 302L,
                subCategory = "Sub Category 3.2",
                imageUrl = "https://example.com/sub-category-3-2.png"
            )
        )
    ),
    SupportedExamResponse(
        id = 4L,
        examName = "Mock Exam 4",
        imageUrl = "https://example.com/exam4-image.png",
        subCategory = listOf(
            ExamSubCategoryResponse(
                id = 401L,
                subCategory = "Sub Category 4.1",
                imageUrl = "https://example.com/sub-category-4-1.png"
            ),
            ExamSubCategoryResponse(
                id = 402L,
                subCategory = "Sub Category 4.2",
                imageUrl = "https://example.com/sub-category-4-2.png"
            )
        )
    ),
    SupportedExamResponse(
        id = 5L,
        examName = "Mock Exam 5",
        imageUrl = "https://example.com/exam5-image.png",
        subCategory = listOf(
            ExamSubCategoryResponse(
                id = 501L,
                subCategory = "Sub Category 5.1",
                imageUrl = "https://example.com/sub-category-5-1.png"
            ),
            ExamSubCategoryResponse(
                id = 502L,
                subCategory = "Sub Category 5.2",
                imageUrl = "https://example.com/sub-category-5-2.png"
            )
        )
    ),
    SupportedExamResponse(
        id = 6L,
        examName = "Mock Exam 6",
        imageUrl = "https://example.com/exam6-image.png",
        subCategory = listOf(
            ExamSubCategoryResponse(
                id = 601L,
                subCategory = "Sub Category 6.1",
                imageUrl = "https://example.com/sub-category-6-1.png"
            ),
            ExamSubCategoryResponse(
                id = 602L,
                subCategory = "Sub Category 6.2",
                imageUrl = "https://example.com/sub-category-6-2.png"
            )
        )
    ),
    SupportedExamResponse(
        id = 7L,
        examName = "Mock Exam 7",
        imageUrl = "https://example.com/exam7-image.png",
        subCategory = listOf(
            ExamSubCategoryResponse(
                id = 701L,
                subCategory = "Sub Category 7.1",
                imageUrl = "https://example.com/sub-category-7-1.png"
            ),
            ExamSubCategoryResponse(
                id = 702L,
                subCategory = "Sub Category 7.2",
                imageUrl = "https://example.com/sub-category-7-2.png"
            )
        )
    ),
    SupportedExamResponse(
        id = 8L,
        examName = "Mock Exam 8",
        imageUrl = "https://example.com/exam8-image.png",
        subCategory = listOf(
            ExamSubCategoryResponse(
                id = 801L,
                subCategory = "Sub Category 8.1",
                imageUrl = "https://example.com/sub-category-8-1.png"
            ),
            ExamSubCategoryResponse(
                id = 802L,
                subCategory = "Sub Category 8.2",
                imageUrl = "https://example.com/sub-category-8-2.png"
            )
        )
    ),
    SupportedExamResponse(
        id = 9L,
        examName = "Mock Exam 9",
        imageUrl = "https://example.com/exam9-image.png",
        subCategory = listOf(
            ExamSubCategoryResponse(
                id = 901L,
                subCategory = "Sub Category 9.1",
                imageUrl = "https://example.com/sub-category-9-1.png"
            ),
            ExamSubCategoryResponse(
                id = 902L,
                subCategory = "Sub Category 9.2",
                imageUrl = "https://example.com/sub-category-9-2.png"
            )
        )
    ),
    SupportedExamResponse(
        id = 10L,
        examName = "Mock Exam 10",
        imageUrl = "https://example.com/exam10-image.png",
        subCategory = listOf(
            ExamSubCategoryResponse(
                id = 1001L,
                subCategory = "Sub Category 10.1",
                imageUrl = "https://example.com/sub-category-10-1.png"
            ),
            ExamSubCategoryResponse(
                id = 1002L,
                subCategory = "Sub Category 10.2",
                imageUrl = "https://example.com/sub-category-10-2.png"
            )
        )
    )
)
