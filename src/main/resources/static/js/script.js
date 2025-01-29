const API_BASE_URL = "/cakes"; // Ensure this matches your backend's base URL

async function searchCakes() {
  const flavour = document.getElementById("flavour-search").value.trim();

  // If the input is empty, clear the results
  if (!flavour) {
    document.getElementById("search-results").innerHTML = "";
    return;
  }

  try {
    // Call the API
    const response = await fetch(`${API_BASE_URL}/search?flavour=${encodeURIComponent(flavour)}`);
    if (response.ok) {
      const cakes = await response.json();

      // Render the results
      const resultsDiv = document.getElementById("search-results");
      if (cakes.length > 0) {
        resultsDiv.innerHTML = cakes
          .map(
            (cake) =>
              `<div>
                <strong>${cake.name}</strong><br>
                Flavour: ${cake.flavour}<br>
                Price: ₹${cake.price}
              </div>`
          )
          .join("");
      } else {
        resultsDiv.innerHTML = "<p>No cakes found.</p>";
      }
    } else {
      console.error("Failed to fetch search results");
    }
  } catch (error) {
    console.error("Error occurred while fetching cakes:", error);
  }
}
