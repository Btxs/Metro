package code.name.monkey.retromusic.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import code.name.monkey.retromusic.model.Song
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
class SongEntity(
    @ColumnInfo(name = "playlist_creator_id")
    val playlistCreatorId: Int,
    val id: Int,
    val title: String,
    @ColumnInfo(name = "track_number")
    val trackNumber: Int,
    val year: Int,
    val duration: Long,
    val data: String,
    @ColumnInfo(name = "date_modified")
    val dateModified: Long,
    @ColumnInfo(name = "album_id")
    val albumId: Int,
    @ColumnInfo(name = "album_name")
    val albumName: String,
    @ColumnInfo(name = "artist_id")
    val artistId: Int,
    @ColumnInfo(name = "artist_name")
    val artistName: String,
    val composer: String?,
    @ColumnInfo(name = "album_artist")
    val albumArtist: String?
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "song_key")
    var songPrimaryKey: Long = 0

    fun toSong(): Song {
        return Song(
            id,
            title,
            trackNumber,
            year,
            duration,
            data,
            dateModified,
            albumId,
            albumName,
            artistId,
            artistName,
            composer,
            albumArtist
        )
    }
}

fun List<SongEntity>.toSongs(): List<Song> {
    return map {
        it.toSong()
    }
}