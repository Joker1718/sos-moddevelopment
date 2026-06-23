/*     */ package init.resources;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ public interface RES_AMOUNT
/*     */ {
/*     */   RESOURCE resource();
/*     */   
/*     */   int amount();
/*     */   
/*     */   static LIST<RES_AMOUNT> make(Json json) {
/*  17 */     LinkedList<RES_AMOUNT> li = new LinkedList();
/*  18 */     for (String k : json.keys()) {
/*  19 */       RESOURCE r = (RESOURCE)RESOURCES.map().tryGet(k);
/*  20 */       if (r != null) {
/*  21 */         li.add(new Imp(r, json.i(k)));
/*     */       }
/*     */     } 
/*  24 */     return (LIST<RES_AMOUNT>)new ArrayList((Iterable)li);
/*     */   }
/*     */   
/*     */   public static class Imp
/*     */     implements RES_AMOUNT, Serializable {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private byte cIndex;
/*     */     private int amount;
/*     */     
/*     */     public Imp() {
/*  34 */       this((RESOURCE)null, 0);
/*     */     }
/*     */     
/*     */     public Imp(RESOURCE c) {
/*  38 */       this(c, 0);
/*     */     }
/*     */     
/*     */     public Imp(RESOURCE c, int amount) {
/*  42 */       if (c != null)
/*  43 */         this.cIndex = c.bIndex(); 
/*  44 */       this.amount = amount;
/*     */     }
/*     */     
/*     */     public Imp(RES_AMOUNT wa, float factor) {
/*  48 */       this.cIndex = wa.resource().bIndex();
/*  49 */       this.amount = (int)(wa.amount() * factor);
/*     */     }
/*     */ 
/*     */     
/*     */     public RESOURCE resource() {
/*  54 */       return (RESOURCE)RESOURCES.ALL().get(this.cIndex);
/*     */     }
/*     */ 
/*     */     
/*     */     public int amount() {
/*  59 */       return this.amount;
/*     */     }
/*     */     
/*     */     public void add(int amount) {
/*  63 */       this.amount += amount;
/*     */     }
/*     */     
/*     */     public void set(int amount) {
/*  67 */       this.amount = amount;
/*     */     }
/*     */     
/*     */     public Imp setResource(RESOURCE res) {
/*  71 */       this.cIndex = res.bIndex();
/*  72 */       return this;
/*     */     }
/*     */     
/*     */     public Imp setResource(RESOURCE res, int amount) {
/*  76 */       this.cIndex = res.bIndex();
/*  77 */       this.amount = amount;
/*  78 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Abs
/*     */     implements RES_AMOUNT
/*     */   {
/*     */     private final byte cIndex;
/*     */     private final int amount;
/*     */     
/*     */     public Abs(RESOURCE c, int amount) {
/*  89 */       this.cIndex = c.bIndex();
/*  90 */       this.amount = amount;
/*     */     }
/*     */ 
/*     */     
/*     */     public RESOURCE resource() {
/*  95 */       return (RESOURCE)RESOURCES.ALL().get(this.cIndex);
/*     */     }
/*     */ 
/*     */     
/*     */     public int amount() {
/* 100 */       return this.amount;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\RES_AMOUNT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */