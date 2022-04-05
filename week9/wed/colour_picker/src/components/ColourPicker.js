const ColourPicker = ({
    red,
    green,
    blue,
    onRedChange,
    onGreenChange,
    onBlueChange
}) => {
    return (
        <>
        <label htmlFor="red">Red</label>
        <input type="range" id="red" onInput={onRedChange}/>
        <p>Red:{red}</p>
        <label htmlFor="green">Green</label>
        <input type="range" id="green" onInput={onGreenChange} />
        <p>Green:{green}</p>

        <label htmlFor="blue">Blue</label>
        <input type="range" id="blue" onInput={onBlueChange} />
        <p>Blue:{blue}</p>

        </>
    )

}

export default ColourPicker;
