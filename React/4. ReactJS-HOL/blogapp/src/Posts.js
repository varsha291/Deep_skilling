import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      posts: []
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => {
        const posts = data.map(
          (item) => new Post(item.id, item.title, item.body)
        );

        this.setState({
          posts: posts
        });
      })
      .catch((error) => {
        alert(error.message);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  render() {
    return (
      <div>
        {this.state.posts.map((post) => (
          <div key={post.id}>
            <h1>{post.title}</h1>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }

  componentDidCatch(error, info) {
    alert(error.message);
  }
}

export default Posts;