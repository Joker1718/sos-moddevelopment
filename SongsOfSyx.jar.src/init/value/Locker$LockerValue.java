/*     */ package init.value;
/*     */ 
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class LockerValue<T>
/*     */   extends Locker<T>
/*     */ {
/*     */   public final Value<T> getter;
/*     */   public final COMPARATOR comp;
/*     */   public final double value;
/*     */   
/*     */   LockerValue(COMPARATOR comp, Value<T> getter, double value, SPRITE icon) {
/*  50 */     super(getter.name, icon);
/*  51 */     this.getter = getter;
/*  52 */     this.comp = comp;
/*  53 */     this.value = value;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean inUnlocked(T t) {
/*  58 */     return this.comp.passes(this.getter.d.getD(t), this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, T t) {
/*  63 */     GBox b = (GBox)text;
/*  64 */     GText name = b.text();
/*  65 */     name.add(this.name);
/*  66 */     name.setMaxWidth(230);
/*  67 */     name.setMultipleLines(true);
/*  68 */     GText va = b.text();
/*  69 */     GText cu = b.text();
/*  70 */     cu.add('(');
/*     */     
/*  72 */     if (this.getter.isBool) {
/*  73 */       GFORMAT.bool(va, (this.value == 1.0D));
/*  74 */       GFORMAT.bool(cu, (this.getter.d.getD(t) == 1.0D));
/*  75 */     } else if (this.getter.percentage) {
/*  76 */       GFORMAT.perc(va, this.value);
/*  77 */       GFORMAT.perc(cu, this.getter.d.getD(t));
/*     */     } else {
/*  79 */       if ((int)this.value == this.value) {
/*  80 */         GFORMAT.iBig(va, (int)this.value);
/*     */       } else {
/*  82 */         GFORMAT.f(va, this.value);
/*     */       } 
/*  84 */       if ((int)this.getter.d.getD(t) == this.getter.d.getD(t)) {
/*  85 */         GFORMAT.iBig(cu, (int)this.getter.d.getD(t));
/*     */       } else {
/*  87 */         GFORMAT.f(cu, this.getter.d.getD(t));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  93 */     GText co = b.text();
/*  94 */     co.add(this.comp.rep);
/*     */     
/*  96 */     if (inUnlocked(t)) {
/*  97 */       name.normalify2();
/*  98 */       va.normalify2();
/*  99 */       co.normalify2();
/*     */     } else {
/* 101 */       name.errorify();
/* 102 */       va.errorify();
/* 103 */       co.errorify();
/*     */     } 
/*     */     
/* 106 */     b.add((SPRITE)name);
/* 107 */     b.tab(6);
/* 108 */     b.add((SPRITE)co);
/* 109 */     b.tab(7);
/* 110 */     b.add((SPRITE)va);
/* 111 */     b.tab(9);
/* 112 */     cu.add(')');
/* 113 */     cu.normalify();
/* 114 */     b.add((SPRITE)cu);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double progress(T t) {
/* 120 */     return this.comp.progress(this.getter.d.getD(t), this.value);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\Locker$LockerValue.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */