import React from 'react';
import { Card, CardMedia, CardContent, CardActions, Typography } from '@material-ui/core';
import { AddShoppingCart } from '@material-ui/icons';

import useStyles from './styles';


const Product = ({ product }) => {
    const classes = useStyles();

  
    return (
        <Card className={classes.root}>
        <CardMedia className={classes.media} image={product.url} title={product.name} />
        <CardContent>
          <div className={classes.cardContent}>
            <Typography gutterBottom variant="h5" component="h2">
              {product.name}
            </Typography>
            <Typography gutterBottom variant="h5" component="h2">
              {product.price}
            </Typography>
          </div>
          <Typography dangerouslySetInnerHTML={{ __html: product.type }} variant="body2" color="textSecondary" component="p" />
          
        </CardContent>
        
      </Card>
    )
}

export default Product
