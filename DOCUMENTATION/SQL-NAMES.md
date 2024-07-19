# FALTA ORGANIZAR


https://github.com/kettanaito/naming-cheatsheet

S-I-D

A name must be short, intuitive and descriptive:

    Short. A name must not take long to type and, therefore, remember;
    Intuitive. A name must read naturally, as close to the common speech as possible;
    Descriptive. A name must reflect what it does/possesses in the most efficient way.

A/HC/LC Pattern

There is a useful pattern to follow when naming functions:

prefix? + action (A) + high context (HC) + low context? (LC)

Take a look at how this pattern may be applied in the table below.
Name 	Prefix 	Action (A) 	High context (HC) 	Low context (LC)
getUser 		get 	User 	
getUserMessages 		get 	User 	Messages
handleClickOutside 		handle 	Click 	Outside
shouldDisplayMessage 	should 	Display 	Message 	

    Note: The order of context affects the meaning of a variable. For example, shouldUpdateComponent means you are about to update a component, while shouldComponentUpdate tells you that component will update itself, and you are only controlling when it should update. In other words, high context emphasizes the meaning of a variable.

Prefixes

Prefix enhances the meaning of a variable. It is rarely used in function names.
is

Describes a characteristic or state of the current context (usually boolean).

const color = 'blue'
const isBlue = color === 'blue' // characteristic
const isPresent = true // state

if (isBlue && isPresent) {
  console.log('Blue is present!')
}

has

Describes whether the current context possesses a certain value or state (usually boolean).

/* Bad */
const isProductsExist = productsCount > 0
const areProductsPresent = productsCount > 0

/* Good */
const hasProducts = productsCount > 0

should

Reflects a positive conditional statement (usually boolean) coupled with a certain action.

function shouldUpdateUrl(url, expectedUrl) {
  return url !== expectedUrl
}

min/max

Represents a minimum or maximum value. Used when describing boundaries or limits.

/**
 * Renders a random amount of posts within
 * the given min/max boundaries.
 */
function renderPosts(posts, minPosts, maxPosts) {
  return posts.slice(0, randomBetween(minPosts, maxPosts))
}

prev/next

Indicate the previous or the next state of a variable in the current context. Used when describing state transitions.

async function getPosts() {
  const prevPosts = this.state.posts

  const latestPosts = await fetch('...')
  const nextPosts = concat(prevPosts, latestPosts)

  this.setState({ posts: nextPosts })
}

Singular and Plurals

Like a prefix, variable names can be made singular or plural depending on whether they hold a single value or multiple values.

/* Bad */
const friends = 'Bob'
const friend = ['Bob', 'Tony', 'Tanya']

/* Good */
const friend = 'Bob'
const friends = ['Bob', 'Tony', 'Tanya']