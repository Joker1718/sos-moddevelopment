/*     */ package game.battle;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ public class ArmyDivOrder
/*     */   implements LIST<Div>
/*     */ {
/*     */   private final Army army;
/*  16 */   private final int[] order = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/*  17 */   private int ii = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Iterator<Div> iterer;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Div> iterator() {
/*  28 */     this.ii = 0;
/*  29 */     return this.iterer;
/*     */   }
/*     */   ArmyDivOrder(Army army) {
/*  32 */     this.iterer = new Iterator<Div>()
/*     */       {
/*     */         public boolean hasNext()
/*     */         {
/*  36 */           return (ArmyDivOrder.this.ii < ArmyDivOrder.this.order.length - 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public Div next() {
/*  41 */           int i = ArmyDivOrder.this.order[ArmyDivOrder.this.ii];
/*  42 */           ArmyDivOrder.this.ii++;
/*  43 */           return (Div)ArmyDivOrder.this.army.divisions().get(i); }
/*     */       };
/*     */     this.army = army;
/*     */     for (int i = 0; i < this.order.length; i++)
/*     */       this.order[i] = i; 
/*     */   } public void swap(Div d1, Div d2) {
/*  49 */     if (d1.army() != this.army || d2.army() != this.army) {
/*  50 */       throw new RuntimeException();
/*     */     }
/*  52 */     int i1 = -1;
/*  53 */     int i2 = -1; byte b; int j, arrayOfInt[];
/*  54 */     for (j = (arrayOfInt = this.order).length, b = 0; b < j; ) { int k = arrayOfInt[b];
/*  55 */       if (k == d1.index())
/*  56 */         i1 = k; 
/*  57 */       if (k == d2.index())
/*  58 */         i2 = k; 
/*     */       b++; }
/*     */     
/*  61 */     if (i1 == -1 || i2 == -1) {
/*  62 */       throw new RuntimeException();
/*     */     }
/*  64 */     int i = this.order[i1];
/*  65 */     this.order[i1] = this.order[i2];
/*  66 */     this.order[i2] = i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void shoveIn(Div div, Div before) {
/*  71 */     if (div.army() != this.army || before.army() != this.army) {
/*  72 */       throw new RuntimeException();
/*     */     }
/*  74 */     boolean f = false; int i;
/*  75 */     for (i = 0; i < this.order.length - 1; i++) {
/*  76 */       int j = f | ((get(i) == div) ? 1 : 0);
/*  77 */       if (j != 0) {
/*  78 */         this.order[i] = this.order[i + 1];
/*     */       }
/*     */     } 
/*     */     
/*  82 */     for (i = this.order.length - 1; i > 0; i--) {
/*  83 */       this.order[i] = this.order[i - 1];
/*  84 */       if (get(i - 1) == before) {
/*  85 */         this.order[i - 1] = div.index();
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void save(FilePutter file) {
/*  93 */     file.is(this.order);
/*     */   }
/*     */ 
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/*  98 */     file.is(this.order);
/*     */   }
/*     */ 
/*     */   
/*     */   void clear() {
/* 103 */     for (int i = 0; i < this.order.length; i++) {
/* 104 */       this.order[i] = i;
/*     */     }
/*     */   }
/*     */   
/*     */   public Div get(int index) {
/* 109 */     return (Div)this.army.divisions().get(this.order[index]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(int i) {
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Div object) {
/* 119 */     return (object.army() == this.army);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 124 */     return this.order.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 129 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\ArmyDivOrder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */