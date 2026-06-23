/*     */ package view.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Armies;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.util.Copyable;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class DivSelection {
/*  13 */   public static CharSequence ¤¤MusterOneProblem = "¤One or more divisions do not have a position. Set a position by clicking the division, then click and drag on the ground where you want them.";
/*  14 */   public static CharSequence ¤¤MusterProblem = "¤The division do not have a position. Set a position by clicking the division, then click and drag on the ground where you want them.";
/*     */   
/*     */   static {
/*  17 */     D.ts(DivSelection.class);
/*     */   }
/*     */   
/*  20 */   private final boolean[] selected = new boolean[Armies.DIVISIONS];
/*  21 */   private final ArrayList<Div> selection = new ArrayList(Armies.DIVISIONS);
/*  22 */   private final boolean[] hovered = new boolean[Armies.DIVISIONS];
/*  23 */   private final DivFormationImp tmp = new DivFormationImp();
/*     */   
/*     */   public void select(Div f) {
/*  26 */     if (this.selected[f.index()])
/*     */       return; 
/*  28 */     this.selection.add(f);
/*  29 */     this.selected[f.index()] = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void deSelect(Div f) {
/*  34 */     if (!this.selected[f.index()])
/*     */       return; 
/*  36 */     this.selection.remove(f);
/*  37 */     this.selected[f.index()] = false;
/*     */   }
/*     */   
/*     */   public boolean selected(Div f) {
/*  41 */     return this.selected[f.index()];
/*     */   }
/*     */   
/*     */   public void sToggle(Div f) {
/*  45 */     if (!this.selected[f.index()]) {
/*  46 */       select(f);
/*     */     } else {
/*  48 */       deSelect(f);
/*     */     } 
/*     */   }
/*     */   public void clear() {
/*  52 */     this.selection.clearSloppy();
/*  53 */     for (int i = 0; i < this.selected.length; i++) {
/*  54 */       this.selected[i] = false;
/*     */     }
/*  56 */     this.artillery.clear();
/*     */   }
/*     */   
/*     */   public LIST<Div> selection() {
/*  60 */     return (LIST<Div>)this.selection;
/*     */   }
/*     */   
/*     */   public int allSelected() {
/*  64 */     return this.selection.size() + this.artillery.selection().size();
/*     */   }
/*     */   
/*     */   public boolean isClear() {
/*  68 */     return (this.selection.size() == 0 && this.artillery.isClear());
/*     */   }
/*     */   
/*     */   public void toggle(Div f) {
/*  72 */     if (selected(f)) {
/*  73 */       deSelect(f);
/*     */     } else {
/*  75 */       select(f);
/*     */     } 
/*     */   }
/*     */   public boolean hovered(Div d) {
/*  79 */     return this.hovered[d.index()];
/*     */   }
/*     */   
/*     */   public void hover(Div d) {
/*  83 */     this.hovered[d.index()] = true;
/*     */   }
/*     */   
/*     */   public void clearHover() {
/*  87 */     for (int i = 0; i < this.hovered.length; i++) {
/*  88 */       this.hovered[i] = false;
/*     */     }
/*  90 */     this.artillery.clearHover();
/*     */   }
/*     */   
/*  93 */   public final CatSelection artillery = new CatSelection();
/*     */ 
/*     */   
/*     */   public int destinations() {
/*  97 */     int i = 0;
/*  98 */     for (Div d : selection()) {
/*  99 */       if (d.menNrOf() > 0) {
/* 100 */         (d.order()).dest.get((Copyable)this.tmp);
/* 101 */         if (this.tmp.deployed() > 0)
/* 102 */           i++; 
/*     */       } 
/*     */     } 
/* 105 */     return i;
/*     */   }
/*     */   
/*     */   public CharSequence musterProblem() {
/* 109 */     int i = selection().size() - destinations();
/* 110 */     if (i > 1)
/* 111 */       return ¤¤MusterProblem; 
/* 112 */     if (i > 0) {
/* 113 */       return ¤¤MusterOneProblem;
/*     */     }
/* 115 */     return null;
/*     */   }
/*     */   
/*     */   public boolean shouldMuster() {
/* 119 */     for (Div d : GAME.ARMIES().player().divisions()) {
/* 120 */       if (d.menNrOf() > 0 && !d.settings().mustering())
/* 121 */         return true; 
/*     */     } 
/* 123 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\DivSelection.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */