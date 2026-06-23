/*     */ package world.army;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayListShort;
/*     */ import snake2d.util.sets.LIST;
/*     */ import world.WORLD;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ public final class ADArmies
/*     */ {
/*     */   final ArrayListShort armies;
/*     */   private final int factionI;
/*  21 */   private final List list = new List();
/*     */ 
/*     */   
/*     */   final long[] data;
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */ 
/*     */   
/*     */   ADArmies(int factionI, int max) {
/*  32 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter f)
/*     */         {
/*  36 */           ADArmies.this.armies.save(f);
/*  37 */           (AD.iinit()).dataT.saver().save(ADArmies.this.faction(), f);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter f) throws IOException {
/*  42 */           ADArmies.this.armies.load(f);
/*  43 */           (AD.iinit()).dataT.loader().load(ADArmies.this.faction(), f);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/*  48 */           ADArmies.this.armies.clear();
/*  49 */           Arrays.fill(ADArmies.this.data, 0L); }
/*     */       };
/*     */     this.factionI = factionI;
/*     */     this.armies = new ArrayListShort(max);
/*     */     this.data = new long[(AD.iinit()).dataT.longCount()]; } public Faction faction() {
/*  54 */     if (this.factionI == -1)
/*  55 */       return null; 
/*  56 */     return FACTIONS.getByIndex(this.factionI);
/*     */   }
/*     */   
/*     */   public LIST<WArmy> all() {
/*  60 */     return this.list;
/*     */   }
/*     */   
/*     */   public boolean canCreate() {
/*  64 */     return ((WORLD.ENTITIES()).armies.canCreate() && this.armies.hasRoom());
/*     */   }
/*     */ 
/*     */   
/*     */   public void disbandAll() {
/*  69 */     while (all().size() > 0) {
/*  70 */       ((WArmy)all().get(0)).disband();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private final class List
/*     */     implements LIST<WArmy>, Iterator<WArmy>
/*     */   {
/*     */     private int ii;
/*     */     
/*     */     public Iterator<WArmy> iterator() {
/*  81 */       this.ii = 0;
/*  82 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public WArmy get(int index) {
/*  87 */       WArmy a = (WORLD.ENTITIES()).armies.get(ADArmies.this.armies.get(index));
/*  88 */       if (a == null)
/*  89 */         throw new RuntimeException("" + index + " " + index + " " + ADArmies.this.armies.get(index)); 
/*  90 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(int i) {
/*  95 */       return (i >= 0 && i < ADArmies.this.armies.size());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(WArmy object) {
/* 100 */       for (int i = 0; i < ADArmies.this.armies.size(); i++) {
/* 101 */         if (get(i) == object)
/* 102 */           return true; 
/*     */       } 
/* 104 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 109 */       return ADArmies.this.armies.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 114 */       return ADArmies.this.armies.isEmpty();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 119 */       return (this.ii < ADArmies.this.armies.size());
/*     */     }
/*     */ 
/*     */     
/*     */     public WArmy next() {
/* 124 */       WArmy r = get(this.ii);
/* 125 */       this.ii++;
/* 126 */       return r;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADArmies.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */