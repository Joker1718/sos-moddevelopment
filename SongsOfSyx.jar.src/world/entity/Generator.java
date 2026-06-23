/*     */ package world.entity;
/*     */ 
/*     */ import init.type.CLIMATE;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.util.Iterator;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Tree;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import world.WORLD;
/*     */ import world.entity.haven.WHavenType;
/*     */ import world.entity.haven.WHavens;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Generator
/*     */ {
/*     */   public Generator() {
/*  25 */     WHavens cc = (WORLD.ENTITIES()).havens;
/*     */     
/*  27 */     ArrayList<WW> spots = new ArrayList(cc.types.size());
/*  28 */     for (int i = 0; i < cc.types.size(); i++) {
/*  29 */       spots.add(new WW((WHavenType)cc.types.get(i)));
/*     */     }
/*     */     
/*  32 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*     */       
/*  34 */       if (!(WORLD.REGIONS()).map.is(c))
/*     */         continue; 
/*  36 */       if ((WORLD.REGIONS()).isCentre.is(c))
/*     */         continue; 
/*  38 */       if ((WORLD.MOUNTAIN()).haser.is(c.x(), c.y()))
/*     */         continue; 
/*  40 */       if ((WORLD.WATER()).has.is(c))
/*     */         continue; 
/*  42 */       if ((WORLD.FOREST()).amount.get(c) > 0.25D) {
/*     */         continue;
/*     */       }
/*  45 */       CLIMATE cl = (CLIMATE)(WORLD.CLIMATE()).getter.get(c);
/*  46 */       for (WW w : spots) {
/*  47 */         w.add(c.x(), c.y(), cl);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  52 */     int[] ni = Alloc.ii(cc.types.size());
/*     */ 
/*     */     
/*  55 */     while (!spots.isEmpty()) {
/*  56 */       DIR d; WW w = (WW)spots.get(RND.rInt(spots.size()));
/*  57 */       if (w.am <= 0.0D || !w.spots.hasMore()) {
/*  58 */         spots.remove(w);
/*     */         
/*     */         continue;
/*     */       } 
/*  62 */       Coovalue c = (Coovalue)w.spots.pollGreatest();
/*     */       
/*  64 */       Iterator<DIR> iterator = DIR.ALLC.iterator(); do { if (!iterator.hasNext()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  70 */           ni[w.w.index()] = ni[w.w.index()] + 1; Str.TMP.clear().add((CharSequence)w.w.names.getC(ni[w.w.index()]));
/*  71 */           Str.TMP.insert(0, (CharSequence)(w.w.race.appearance()).lastNamesNoble.getC(RND.rInt(65535)));
/*     */           
/*  73 */           cc.create(c.tx, c.ty, w.w, RND.rFloat(), (CharSequence)Str.TMP);
/*  74 */           w.am--;
/*     */           break;
/*     */         } 
/*     */         d = iterator.next(); }
/*     */       while ((WORLD.ENTITIES()).havens.fillTile(c.tx + d.x(), c.ty + d.y()).size() <= 0);
/*     */     } 
/*     */   }
/*     */   
/*  82 */   private static class WW { double am = 0.0D;
/*  83 */     private final Tree<Generator.Coovalue> spots = new Tree<Generator.Coovalue>(1024)
/*     */       {
/*     */         protected boolean isGreaterThan(Generator.Coovalue current, Generator.Coovalue cmp)
/*     */         {
/*  87 */           return (current.value > cmp.value);
/*     */         }
/*     */       };
/*     */     public final WHavenType w;
/*     */     WW(WHavenType w) {
/*  92 */       this.w = w;
/*     */     }
/*     */     
/*     */     void add(int tx, int ty, CLIMATE cl) {
/*  96 */       double res = 0.0D;
/*  97 */       for (TERRAIN t : TERRAINS.ALL()) {
/*  98 */         res += this.w.climates[cl.index()] * this.w.terrains[t.index()] * t.value(tx, ty);
/*     */       }
/* 100 */       this.am += res;
/*     */       
/* 102 */       if (!this.spots.hasRoom()) {
/* 103 */         if (((Generator.Coovalue)this.spots.smallest()).value < res) {
/* 104 */           this.spots.pollSmallest();
/*     */         } else {
/*     */           return;
/*     */         } 
/*     */       }
/*     */       
/* 110 */       Generator.Coovalue v = new Generator.Coovalue();
/* 111 */       v.value = res * RND.rFloat();
/* 112 */       v.tx = (short)tx;
/* 113 */       v.ty = (short)ty;
/* 114 */       this.spots.add(v);
/*     */     } }
/*     */ 
/*     */   
/*     */   private static class Coovalue {
/*     */     short tx;
/*     */     short ty;
/*     */     double value;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\Generator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */