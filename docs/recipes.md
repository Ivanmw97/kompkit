# Recipes

Real-world examples using KompKit Core utilities.

## Debounced search input (React)

```tsx
import { useState, useEffect } from "react";
import { debounce } from "@kompkit/core";

function SearchComponent() {
  const [query, setQuery] = useState("");
  const [results, setResults] = useState([]);

  useEffect(() => {
    const search = debounce(async (q: string) => {
      if (!q) return;
      const res = await fetch(`/api/search?q=${q}`);
      const data = await res.json();
      setResults(data);
    }, 400);

    search(query);
  }, [query]);

  return (
    <div>
      <input
        type="text"
        value={query}
        onChange={(e) => setQuery(e.target.value)}
        placeholder="Search..."
      />
      <ul>
        {results.map((item) => (
          <li key={item.id}>{item.name}</li>
        ))}
      </ul>
    </div>
  );
}
```

## Debounced TextField in Compose

```kotlin
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.kompkit.core.debounce
import kotlinx.coroutines.launch

@Composable
fun SearchScreen() {
    var query by remember { mutableStateOf("") }
    var results by remember { mutableStateOf(listOf<String>()) }
    val scope = rememberCoroutineScope()

    val search = remember {
        debounce<String>(400L, scope) { q ->
            scope.launch {
                if (q.isNotEmpty()) {
                    results = fetchResults(q)
                }
            }
        }
    }

    Column {
        TextField(
            value = query,
            onValueChange = { newValue ->
                query = newValue
                search(newValue)
            },
            placeholder = { Text("Search...") }
        )
        LazyColumn {
            items(results) { item ->
                Text(item)
            }
        }
    }
}

suspend fun fetchResults(query: String): List<String> {
    // API call here
    return emptyList()
}
```

## Currency formatting with locale switch

```tsx
import { useState } from "react";
import { formatCurrency } from "@kompkit/core";

function PriceDisplay({ amount }: { amount: number }) {
  const [locale, setLocale] = useState<"en-US" | "es-ES" | "ja-JP">("en-US");

  const localeConfig = {
    "en-US": { currency: "USD", locale: "en-US" },
    "es-ES": { currency: "EUR", locale: "es-ES" },
    "ja-JP": { currency: "JPY", locale: "ja-JP" },
  };

  const config = localeConfig[locale];
  const formatted = formatCurrency(amount, config.currency, config.locale);

  return (
    <div>
      <p>Price: {formatted}</p>
      <select value={locale} onChange={(e) => setLocale(e.target.value as any)}>
        <option value="en-US">USD</option>
        <option value="es-ES">EUR</option>
        <option value="ja-JP">JPY</option>
      </select>
    </div>
  );
}
```

## Email validation on form submission

```tsx
import { useState } from "react";
import { isEmail } from "@kompkit/core";

function ContactForm() {
  const [email, setEmail] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!isEmail(email)) {
      setError("Please enter a valid email address");
      return;
    }
    setError("");
    // Submit form
    console.log("Submitting:", email);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        placeholder="Email"
      />
      {error && <p style={{ color: "red" }}>{error}</p>}
      <button type="submit">Submit</button>
    </form>
  );
}
```
