angular.module('crudApp').factory('PullRequest',PullRequest);

PullRequest.$inject=['$resource'];

function PullRequest($resource){
	
	var resourceUrl = 'http://localhost:8080/api/pullRequest/getPullRequest/:id';

	return $resource(resourceUrl,{},{
		'update': {
			method: 'PUT'
		}
	})
}