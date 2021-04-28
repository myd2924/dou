package com.myd.dou.jdk8.functionin;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/26 18:52
 * @Description:
 */

@NoArgsConstructor
public class SkuPurchaseRequest {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    private String school;

    @Getter
    private List<Addre> addreList = new ArrayList<>();

    /**
     * 追加器
     * @param list
     * @param <T>
     * @return
     */
    public <T> AddreAppender<T> getAppender(List<T> list){
        return new AddreAppender(this,list);
    }


    public static class AddreAppender<T>{

        private SkuPurchaseRequest target;
        private List<T> orgins = new ArrayList<>(0);

        private BiFunction<T, Addre.AddreBuilder, Addre> function;

        public AddreAppender(SkuPurchaseRequest target, List<T> orgins) {
            this.target = target;
            this.withList(orgins);
        }

        public void append(){
            List<Addre> collect = this.orgins.stream().map((o) -> this.function.apply(o, Addre.builder()))
                    .filter(o -> o != null).collect(Collectors.toList());
            this.target.addreList.addAll(collect);
        }

        private AddreAppender withList(List<T> orgins) {
            Collection<T> _list = CollectionUtils.emptyIfNull(orgins);
            _list = _list.stream().filter(f->f != null).collect(Collectors.toList());
            this.orgins.addAll(_list);
            return this;
        }

        public AddreAppender processor(BiFunction<T, Addre.AddreBuilder, Addre> function){
            this.function = function;
            return this;
        }
    }

    @Builder
    @Getter
    public static class Addre{
        private String addreName;
        private String addreCode;
    }
}
