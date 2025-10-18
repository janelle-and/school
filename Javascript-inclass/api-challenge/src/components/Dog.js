import React, {useState} from 'react';

function Dog(){
    const [dogImage, setDogImage] = useState(null);
    const [advice, setAdvice] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const fetchDogImage = async () => {
        setLoading(true);
        setError(null);

        // gets the selected breed from the dropdown
        const dogBreed = document.getElementById("dogBreed").value;

        try {
            // Fetch dog image
            const response = await fetch(`https://dog.ceo/api/breed/${dogBreed}/images/random`);
            if (!response.ok) throw new Error("Failed to fetch dog image");

            // Fetch advice
            const responseAdvice = await fetch('https://api.adviceslip.com/advice');
            if (!responseAdvice.ok) throw new Error("Failed to fetch advice");

            const adviceData = await responseAdvice.json();
            setAdvice(adviceData.slip.advice);

            const data = await response.json();
            setDogImage(data.message);
        } catch (error) {
            setError(error.message);
        } finally {
            setLoading(false);
        }
    }

    return (
        <div style={{textAlign: 'center', marginTop: '50px'}}>
            <div>
                <h1>🐶 Random Dog Image</h1>
                {/* Dropdown for dog breeds */}
                <label htmlFor="dogBreed" style={{padding: '5px'}}>Choose a dog breed:</label>
                <select id="dogBreed" name="dogBreed" style={{padding: '5px'}}>
                    <option value="terrier">Terrier</option>
                    <option value="hound">Hound</option>
                    <option value="affenpinscher">Affenpinscher</option>
                    <option value="labrador">Labrador</option>
                    <option value="husky">Husky</option>
                    <option value="retriever">Retriever</option>
                    <option value="bulldog">Bulldog</option>
                    <option value="beagle">Beagle</option>
                    <option value="poodle">Poodle</option>
                    <option value="chihuahua">Chihuahua</option>
                    <option value="dalmatian">Dalmatian</option>
                    <option value="boxer">Boxer</option>
                    <option value="corgi">Corgi</option>
                    <option value="doberman">Doberman</option>
                    <option value="mastiff">Mastiff</option>
                    <option value="pug">Pug</option>
                    <option value="rottweiler">Rottweiler</option>
                    <option value="shepherd">Shepherd</option>
                    <option value="shiba">Shiba</option>
                    <option value="spaniel">Spaniel</option>
                    <option value="weimaraner">Weimaraner</option>
                    <option value="whippet">Whippet</option>
                    <option value="wolfhound">Wolfhound</option>
                    <option value="yorkshire">Yorkshire</option>
                    <option value="mix">Mix</option>
                </select>
            </div>
            <div>
                <button onClick={fetchDogImage} style={{marginTop: '10px', padding: '10px', fontSize: '16px'}}> Fetch Dog Image</button>
            </div>
            <div>
                {loading && <p>Loading...</p>}
                {error && <p style={{color: 'red'}}>Error: {error}</p>}
                {dogImage && <img src={dogImage} alt="A Random Dog" style={{marginTop: '20px', maxWidth: '350px', height: 'auto'}} />}
                {advice && <p style={{marginTop: '20px', fontStyle: 'italic'}}>Advice: {advice}</p>}
            </div>
        </div>
    );
}

export default Dog;
