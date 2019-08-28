import * as React from "react";
import { IProduct } from "../../types/IProduct";
import './ProductListing.css';

interface IProps {
  products: IProduct[];
  randomList: boolean;
}


export class  ProductListing extends React.Component<IProps, {}> {
  render() {
    let header = "";
    if (this.props.randomList) {
      header = "No search result found, Alternative Search Result";
    } else {
      header = "Search Result";
    }
    const products = this.props.products.map(product => (
      <tr key={product.id}>
        <td>{product.id}</td>
        <td>{product.title}</td>
        <td>{product.price}</td>
        <td>{product.brand}</td>
        <td><img className="image" src={product.image} /></td>
      </tr>
    ));
    return (
      <div>
        <h2>{header}</h2>
        <table>
          <thead>
            <tr>
              <td>Id</td>
              <td>Title</td>
              <td>Price</td>
              <td>Brand</td>
              <td>Image</td>
            </tr>
          </thead>
          <tbody>{products}</tbody>
        </table>
      </div>
    );
  }
}
