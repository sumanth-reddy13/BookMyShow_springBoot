package com.example.BackendDev.BookMyShow.EntryDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMoviesByGenreEntryDto {
    private String genre;
}
