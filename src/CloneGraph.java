import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
public class CloneGraph {
	private HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return graph(node);
    }
    private UndirectedGraphNode graph(UndirectedGraphNode node){
        if(node == null){
            return node;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node,clone);
        for(UndirectedGraphNode neighbor : node.neighbors){
            clone.neighbors.add(graph(neighbor));
        }
        return clone;
    }
}
