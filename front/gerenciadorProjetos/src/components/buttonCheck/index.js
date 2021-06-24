import style from "../../style/temas";

const Button = ({as="",label="",select=false,name="",onClick="",onChange="",...props})=>{
  return (
    <input style={{background:(select === false ? "white" : (style !== undefined ? style.secondary.background:""))}} type="button" 
      onChange={onChange} value={label} name={name} onClick={onClick} {...props}></input>
  );
};

export default Button;