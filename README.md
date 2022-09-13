# AndroidInterviewCodingStarterRepo
A Starter repo for the Android NASA problem. A candidate in an interview may be asked to whiteboard or implement a solution to the following problem. This repo acta
as a starting point so someone can easily clone and start coding, this included a bit of boilerplate code including:
- A fragment and viewModel for the DateList
- A working example of a RecyclerView that is currently populated with mock data
- An example of a Fragment subscribing and updating to a LiveData field on a ViewModel
# EPIC (Earth Polychromatic Imaging Camera) Imagery

[API Information](https://epic.gsfc.nasa.gov/about/api)

## API interaction

- Find available dates [via the `all` endpoint](https://epic.gsfc.nasa.gov/api/enhanced/all). This returns a JSON array of objects containing date strings indicating the dates that have image data available. The date string is used in the URL of the next call.
- Find images for a given date [via the `date` endpoint](https://epic.gsfc.nasa.gov/api/enhanced/date/2018-06-01). This returns a JSON array of objects. Each object has an identifier, a timestamp, and a filename fragment. You can use the timestamp and the filename fragment to derive the image URL.
- Fetch the images for a given date [via an `archive` URL](https://epic.gsfc.nasa.gov/archive/enhanced/2018/06/01/png/epic_RGB_20180601105347.png).

## App Specification

- Day list (home screen) - The UI for this has been started, although the API calls will need to be hooked up and the table will need to be populated with Dates from the server:
    - A list that shows the dates with available data. Each row will show a date. On the left side of the row, there will be an indicator:
        - If no data is downloaded for that day, show an empty circle.
        - If data is being downloaded for that day, show a progress indicator.
        - If all data is downloaded for that day, show a checkmark.
    - Selecting a row takes you to the photo list.
- Photo list:
    - A grid view of images for this day.
    - If an image has been downloaded, show a thumbnail of the image.
    - If the image is being downloaded, show a progress indicator similar to the one used above. A placeholder thumbnail should be shown.
    - Tapping the area of a downloaded image takes you to the photo screen.
    - In the toolbar menu at the top of the screen is a play icon. This button is disabled while this day’s downloads are in progress. Tapping this takes you to the player screen.
- Photo screen
    - Show a downloaded photo scaled to fit the screen.
    - Allow the user to pinch to zoom, use one finger to pan the image.
    - Provide a menu icon on the toolbar to show metadata about the photo.

- # Bonus
- Add in a Player screen
    - Show an animated sequence of the images for the day. The animation should proceed at 24 frames per second.
    - Sliding one finger over the image should scrub forward or backward through the animation.
    - Allow the user to pinch to zoom, use two fingers to pan the image.
