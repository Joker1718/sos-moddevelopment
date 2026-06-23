/*     */ package game.faction.player.emmi;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ 
/*     */ public abstract class EmiType<T>
/*     */   implements INT_O.INT_OE<T>
/*     */ {
/*  19 */   private static CharSequence ¤¤pointsAllocated = "Points Allocated";
/*  20 */   private static CharSequence ¤¤pointsAvailable = "Points Available";
/*  21 */   private static CharSequence ¤¤Effectivness = "Effectiveness";
/*     */   
/*     */   static {
/*  24 */     D.ts(EmiType.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final SPRITE icon;
/*     */   public final CharSequence name;
/*     */   public final CharSequence desc;
/*     */   private final int[] ams;
/*     */   private int total;
/*     */   private final int max;
/*     */   
/*     */   EmiType(SPRITE icon, CharSequence name, CharSequence desc, int size, int max) {
/*  36 */     this.name = name;
/*  37 */     this.desc = desc;
/*  38 */     this.icon = icon;
/*  39 */     this.ams = Alloc.ii(size);
/*  40 */     this.max = max;
/*     */   }
/*     */   
/*     */   public int total() {
/*  44 */     return this.total;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(T t) {
/*  49 */     return this.ams[index(t)];
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(T t) {
/*  54 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(T t) {
/*  59 */     return this.max;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getD(T t) {
/*  64 */     return get(t) / this.max;
/*     */   }
/*     */   
/*     */   int get(int index) {
/*  68 */     return this.ams[index];
/*     */   }
/*     */   
/*     */   void set(int index, int value) {
/*  72 */     count(index, -this.ams[index]);
/*  73 */     this.ams[index] = value;
/*  74 */     count(index, this.ams[index]);
/*     */   }
/*     */   
/*     */   void count(int index, int am) {
/*  78 */     this.total += am;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(T t, int i) {
/*  83 */     int index = index(t);
/*  84 */     set(index, i);
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/*  88 */     file.isE(this.ams);
/*     */   }
/*     */ 
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/*  93 */     clear();
/*  94 */     file.isE(this.ams);
/*  95 */     this.total = 0;
/*  96 */     for (int i = 0; i < this.ams.length; i++) {
/*  97 */       count(i, this.ams[i]);
/*     */     }
/*     */   }
/*     */   
/*     */   void clear() {
/* 102 */     Arrays.fill(this.ams, 0);
/* 103 */     this.total = 0;
/*     */   }
/*     */   
/*     */   abstract int index(T paramT);
/*     */   
/*     */   public void hover(T t, GUI_BOX text) {
/* 109 */     GBox b = (GBox)text;
/* 110 */     b.title(this.name);
/* 111 */     b.text(this.desc);
/* 112 */     b.NL(4);
/*     */     
/* 114 */     b.textLL(¤¤pointsAllocated);
/* 115 */     b.tab(6);
/* 116 */     b.add((SPRITE)GFORMAT.i(b.text(), get(t)));
/* 117 */     b.NL();
/*     */     
/* 119 */     b.textLL(¤¤pointsAvailable);
/* 120 */     b.tab(6);
/* 121 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (FACTIONS.player()).emissaries.available()));
/* 122 */     b.NL();
/*     */     
/* 124 */     b.textLL(¤¤Effectivness);
/* 125 */     b.tab(6);
/* 126 */     b.add((SPRITE)GFORMAT.perc(b.text(), (FACTIONS.player()).emissaries.penaltyMul()));
/* 127 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\emmi\EmiType.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */