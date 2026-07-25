package Graph;

import java.util.*;

/**
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 */
public class Gene {
    public int minMutation(String startGene, String endGene, String[] bank){

        if (startGene.equals(endGene)){
            return 0;
        }

        //将bank中的基因数组转换成set集合
        Set<String> genes = new HashSet<>(Arrays.asList(bank));
        if (!genes.contains(endGene)){
            return -1;
        }

        //创建一个队列
        Deque<String> queue = new LinkedList<>();
        queue.offer(startGene);

        char[] gene = {'C', 'G', 'A', 'T'};
        int steps = 0;

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                //取出当前基因
                String curGene = queue.poll();
                if (curGene.equals(endGene)){
                    return steps;
                }

                //将当前基因字符串转换成字符数组
                char[] geneArray = curGene.toCharArray();

                for (int j = 0; j < geneArray.length; j++) {
                    //拿到当前基因的字符,准备变异
                    char originalChar = geneArray[j];

                    for (int k = 0; k < gene.length; k++) {
                        //如果变异的字符相等,则跳过
                        if (originalChar == gene[k]){
                            continue;
                        }

                        //开始变异
                        geneArray[j] = gene[k];
                        String newGene = new String(geneArray);

                        //看看是不是在基因库中
                        if (genes.contains(newGene)){
                            //如果正好是目标基因的话,返回结果
                            if (newGene.equals(endGene)){
                                return steps + 1;
                            }
                            //否则将该基因入队,继续下一次变异,并且在基因库中删除该基因
                            queue.offer(newGene);
                            genes.remove(newGene);
                        }
                    }

                    //要对变换的字符进行回朔
                    geneArray[j] = originalChar;
                }
            }

            //当前层级遍历完毕
            steps++;
        }

        return -1;
    }


}
