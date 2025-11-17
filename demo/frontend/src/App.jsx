import { useState } from "react";

function App() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [message, setMessage] = useState("");

    const handleLogin = async () => {
        try {
            const response = await fetch("http://localhost:8080/signIn", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    username: username,
                    password: password,
                }),
            });

            const result = await response.text();
            setMessage(result);
        } catch (error) {
            setMessage("Error: Cannot connect to server");
        }
    };

    return (
        <div style={{ padding: "40px", maxWidth: "300px", margin: "auto" }}>
            <h2>Login</h2>

            <input
                type="text"
                placeholder="Username"
                onChange={(e) => setUsername(e.target.value)}
                style={{ width: "100%", marginBottom: "10px" }}
            />

            <input
                type="password"
                placeholder="Password"
                onChange={(e) => setPassword(e.target.value)}
                style={{ width: "100%", marginBottom: "10px" }}
            />

            <button onClick={handleLogin} style={{ width: "100%" }}>
                Login
            </button>

            {message && (
                <p style={{ marginTop: "20px", fontWeight: "bold" }}>{message}</p>
            )}
        </div>
    );
}

export default App;
