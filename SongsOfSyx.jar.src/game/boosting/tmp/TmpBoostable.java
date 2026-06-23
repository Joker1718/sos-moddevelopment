/*    */ package game.boosting.tmp;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.boosting.BOOSTING;
/*    */ import game.boosting.Boostable;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.INDEXED;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ 
/*    */ public final class TmpBoostable<T extends INDEXED> {
/*    */   public final int startIndex;
/*    */   public final int max;
/*    */   private final TmpBoosting daddy;
/*    */   
/*    */   TmpBoostable(ArrayListGrower<TmpBoostable<?>> all, int max, TmpBoosting daddy) {
/* 19 */     int i = 0;
/* 20 */     for (TmpBoostable<?> t : all) {
/* 21 */       i += t.max;
/*    */     }
/* 23 */     this.startIndex = i;
/* 24 */     this.max = max;
/* 25 */     this.daddy = daddy;
/* 26 */     all.add(this);
/*    */   }
/*    */   
/*    */   public Data get(T t) {
/* 30 */     return this.daddy.datas[this.startIndex + t.index()];
/*    */   }
/*    */   
/*    */   public void set(T t, TmpBoostSpec s, boolean set) {
/* 34 */     get(t).set(s, set);
/*    */   }
/*    */   
/*    */   public void toggle(T t, TmpBoostSpec s) {
/* 38 */     get(t).set(s, !is(t, s));
/*    */   }
/*    */   
/*    */   public boolean is(T t, TmpBoostSpec s) {
/* 42 */     return get(t).is(s);
/*    */   }
/*    */   
/*    */   public double add(T t, Boostable bo) {
/* 46 */     return get(t).add(bo);
/*    */   }
/*    */   
/*    */   public double mul(T t, Boostable bo) {
/* 50 */     return get(t).mul(bo);
/*    */   }
/*    */   
/*    */   public boolean any(T t) {
/* 54 */     return get(t).hasAny();
/*    */   }
/*    */   
/*    */   public void clear(T t) {
/* 58 */     get(t).clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public void hover(GBox b, T t) {
/* 63 */     for (TmpBoostSpec s : GAME.BOOST().specs()) {
/* 64 */       if (is(t, s)) {
/* 65 */         b.add(s.icon);
/* 66 */         b.textLL(s.name);
/* 67 */         b.NL();
/* 68 */         b.text(s.desc);
/* 69 */         b.NL(8);
/*    */         
/* 71 */         for (Boostable bo : BOOSTING.ALL()) {
/*    */           
/* 73 */           if (add(t, bo) != 0.0D) {
/* 74 */             b.add((SPRITE)bo.icon);
/* 75 */             b.textL(bo.name);
/* 76 */             b.tab(6);
/* 77 */             b.add((SPRITE)GFORMAT.f0(b.text(), add(t, bo)));
/* 78 */             b.NL();
/*    */           } 
/* 80 */           if (mul(t, bo) != 1.0D) {
/* 81 */             b.add((SPRITE)bo.icon);
/* 82 */             b.textL(bo.name);
/* 83 */             b.tab(6);
/* 84 */             GText tt = b.text();
/* 85 */             tt.add('*');
/* 86 */             b.add((SPRITE)GFORMAT.f1(tt, mul(t, bo)));
/* 87 */             b.NL();
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\tmp\TmpBoostable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */