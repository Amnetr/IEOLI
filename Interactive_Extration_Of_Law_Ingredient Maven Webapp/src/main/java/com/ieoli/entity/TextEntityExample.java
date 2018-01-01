package com.ieoli.entity;

import java.util.ArrayList;
import java.util.List;

public class TextEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TextEntityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTextidIsNull() {
            addCriterion("textID is null");
            return (Criteria) this;
        }

        public Criteria andTextidIsNotNull() {
            addCriterion("textID is not null");
            return (Criteria) this;
        }

        public Criteria andTextidEqualTo(Integer value) {
            addCriterion("textID =", value, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidNotEqualTo(Integer value) {
            addCriterion("textID <>", value, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidGreaterThan(Integer value) {
            addCriterion("textID >", value, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidGreaterThanOrEqualTo(Integer value) {
            addCriterion("textID >=", value, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidLessThan(Integer value) {
            addCriterion("textID <", value, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidLessThanOrEqualTo(Integer value) {
            addCriterion("textID <=", value, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidIn(List<Integer> values) {
            addCriterion("textID in", values, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidNotIn(List<Integer> values) {
            addCriterion("textID not in", values, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidBetween(Integer value1, Integer value2) {
            addCriterion("textID between", value1, value2, "textid");
            return (Criteria) this;
        }

        public Criteria andTextidNotBetween(Integer value1, Integer value2) {
            addCriterion("textID not between", value1, value2, "textid");
            return (Criteria) this;
        }

        public Criteria andModelidIsNull() {
            addCriterion("ModelID is null");
            return (Criteria) this;
        }

        public Criteria andModelidIsNotNull() {
            addCriterion("ModelID is not null");
            return (Criteria) this;
        }

        public Criteria andModelidEqualTo(Integer value) {
            addCriterion("ModelID =", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidNotEqualTo(Integer value) {
            addCriterion("ModelID <>", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidGreaterThan(Integer value) {
            addCriterion("ModelID >", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ModelID >=", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidLessThan(Integer value) {
            addCriterion("ModelID <", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidLessThanOrEqualTo(Integer value) {
            addCriterion("ModelID <=", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidIn(List<Integer> values) {
            addCriterion("ModelID in", values, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidNotIn(List<Integer> values) {
            addCriterion("ModelID not in", values, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidBetween(Integer value1, Integer value2) {
            addCriterion("ModelID between", value1, value2, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidNotBetween(Integer value1, Integer value2) {
            addCriterion("ModelID not between", value1, value2, "modelid");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andTextnameIsNull() {
            addCriterion("textName is null");
            return (Criteria) this;
        }

        public Criteria andTextnameIsNotNull() {
            addCriterion("textName is not null");
            return (Criteria) this;
        }

        public Criteria andTextnameEqualTo(String value) {
            addCriterion("textName =", value, "textname");
            return (Criteria) this;
        }

        public Criteria andTextnameNotEqualTo(String value) {
            addCriterion("textName <>", value, "textname");
            return (Criteria) this;
        }

        public Criteria andTextnameGreaterThan(String value) {
            addCriterion("textName >", value, "textname");
            return (Criteria) this;
        }

        public Criteria andTextnameGreaterThanOrEqualTo(String value) {
            addCriterion("textName >=", value, "textname");
            return (Criteria) this;
        }

        public Criteria andTextnameLessThan(String value) {
            addCriterion("textName <", value, "textname");
            return (Criteria) this;
        }

        public Criteria andTextnameLessThanOrEqualTo(String value) {
            addCriterion("textName <=", value, "textname");
            return (Criteria) this;
        }

        public Criteria andTextnameLike(String value) {
            addCriterion("textName like", value, "textname");
            return (Criteria) this;
        }

        public Criteria andTextnameNotLike(String value) {
            addCriterion("textName not like", value, "textname");
            return (Criteria) this;
        }

        public Criteria andTextnameIn(List<String> values) {
            addCriterion("textName in", values, "textname");
            return (Criteria) this;
        }

        public Criteria andTextnameNotIn(List<String> values) {
            addCriterion("textName not in", values, "textname");
            return (Criteria) this;
        }

        public Criteria andTextnameBetween(String value1, String value2) {
            addCriterion("textName between", value1, value2, "textname");
            return (Criteria) this;
        }

        public Criteria andTextnameNotBetween(String value1, String value2) {
            addCriterion("textName not between", value1, value2, "textname");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}