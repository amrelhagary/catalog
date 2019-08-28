import * as React from "react";
import { ProductListing } from "../ProductListing/ProductListing";
import { IProduct } from "../../types/IProduct";
import { API_BASE_URL } from "../../config";

interface IState {
  searchableProductTitle: string;
  products: IProduct[];
  randomList: boolean;
}

export class ProductSearch extends React.Component<{}, IState> {
  constructor(props: any) {
    super(props);
    this.state = {
      searchableProductTitle: "",
      products: [],
      randomList: false
    };

    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async componentDidMount() {
    const response = await fetch(`${API_BASE_URL}/product`);
    const list = await response.json();
    this.setState({ products: list, randomList: false });
  }

  async handleSubmit(event: any) {
    event.preventDefault();
    this.setState({ randomList: false });
    let response = await fetch(
      `${API_BASE_URL}/product?title=${this.state.searchableProductTitle}`
    );

    let list = await response.json();
    if (list.length === 0) {
      response = await fetch(`${API_BASE_URL}/product/random`);
      list = await response.json();
      this.setState({ randomList: true });
    }

    this.setState({ products: list });
  }

  changeSearchableProductTitle(event: any) {
    this.setState({ searchableProductTitle: event.target.value });
  }

  render() {
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <input
            type="text"
            name="searchProductTitle"
            value={this.state.searchableProductTitle}
            onChange={this.changeSearchableProductTitle.bind(this)}
          />
          <button type="submit" id="searchBtn" name="searchBtn">
            Search
          </button>
        </form>
        <ProductListing
          products={this.state.products}
          randomList={this.state.randomList}
        />
      </div>
    );
  }
}
