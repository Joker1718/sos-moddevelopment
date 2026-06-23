/*     */ package world.region;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayListShortResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Realm
/*     */ {
/*  19 */   final ArrayListShortResize regions = new ArrayListShortResize(32, 1023);
/*  20 */   private final List list = new List();
/*  21 */   short capitolI = -1;
/*     */   
/*     */   private final short index;
/*  24 */   double ferArea = 0.0D;
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */   
/*     */   Realm(int index) {
/*  30 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  34 */           Realm.this.regions.save(file);
/*  35 */           file.s(Realm.this.capitolI);
/*  36 */           file.d(Realm.this.ferArea);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  41 */           Realm.this.regions.load(file);
/*  42 */           Realm.this.capitolI = file.s();
/*  43 */           Realm.this.ferArea = file.d();
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/*  48 */           Realm.this.regions.clear();
/*  49 */           Realm.this.capitolI = -1;
/*  50 */           Realm.this.ferArea = 0.0D;
/*     */         }
/*     */       };
/*     */     this.index = (short)index;
/*     */   } public double ferArea() {
/*  55 */     return this.ferArea;
/*     */   }
/*     */   
/*     */   public LIST<Region> all() {
/*  59 */     return this.list;
/*     */   }
/*     */   
/*     */   public int regions() {
/*  63 */     return this.regions.size();
/*     */   }
/*     */   
/*     */   public Region region(int i) {
/*  67 */     return (Region)WORLD.REGIONS().all().get(this.regions.get(i));
/*     */   }
/*     */   
/*     */   public Region capitol() {
/*  71 */     if (this.capitolI == -1)
/*  72 */       return null; 
/*  73 */     return WORLD.REGIONS().getByIndex(this.capitolI);
/*     */   }
/*     */   
/*     */   public Faction faction() {
/*  77 */     return FACTIONS.getByIndex(this.index);
/*     */   }
/*     */   
/*     */   private class List
/*     */     implements LIST<Region>, Iterator<Region>
/*     */   {
/*     */     private int ii;
/*     */     
/*     */     public Iterator<Region> iterator() {
/*  86 */       this.ii = 0;
/*  87 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Region get(int index) {
/*  92 */       return WORLD.REGIONS().getByIndex(Realm.this.regions.get(index));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(int i) {
/*  97 */       return (i >= 0 && i < Realm.this.regions.size());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Region object) {
/* 102 */       for (int i = 0; i < Realm.this.regions.size(); i++) {
/* 103 */         if (get(i) == object)
/* 104 */           return true; 
/*     */       } 
/* 106 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 111 */       return Realm.this.regions.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 116 */       return Realm.this.regions.isEmpty();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 121 */       return (this.ii < Realm.this.regions.size());
/*     */     }
/*     */ 
/*     */     
/*     */     public Region next() {
/* 126 */       Region r = get(this.ii);
/* 127 */       this.ii++;
/* 128 */       return r;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\Realm.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */