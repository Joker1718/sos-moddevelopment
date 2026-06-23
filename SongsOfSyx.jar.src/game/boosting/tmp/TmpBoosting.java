/*     */ package game.boosting.tmp;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Booster;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ public class TmpBoosting
/*     */   extends GAME.GameResource
/*     */ {
/*  30 */   private static CharSequence ¤¤regs = "Affected Regions";
/*  31 */   private static CharSequence ¤¤groups = "Affected Groups"; static ArrayListGrower<TmpBoostSpec> allTmp; static KeyMap<TmpBoostSpec> allMap;
/*     */   
/*     */   static {
/*  34 */     D.ts(TmpBoosting.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   private final ArrayListGrower<TmpBoostable<?>> all = new ArrayListGrower();
/*  41 */   public final TmpBoostable<Region> regions = new TmpBoostable<>(this.all, 1023, this);
/*  42 */   public final TmpBoostable<HCLASS_RACE> popcl = new TmpBoostable<>(this.all, HCLASS_RACE.ALL().size(), this);
/*  43 */   public final TmpBoostable<Faction> factions = new TmpBoostable<>(this.all, FACTIONS.MAX(), this);
/*     */   
/*     */   private final ArrayListGrower<TmpBoostSpec> specs;
/*  46 */   final Data[] datas = new Data[((TmpBoostable)this.all.get(this.all.size() - 1)).startIndex + ((TmpBoostable)this.all.get(this.all.size() - 1)).max];
/*     */   
/*     */   public TmpBoosting(GAME game) {
/*  49 */     super("TEMP_EVENTS");
/*  50 */     allTmp = new ArrayListGrower();
/*  51 */     allMap = new KeyMap();
/*  52 */     this.specs = allTmp;
/*  53 */     GAME.addOnViewInit(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  57 */             TmpBoosting.allTmp = null;
/*     */             
/*  59 */             for (int i = 0; i < TmpBoosting.this.datas.length; i++) {
/*  60 */               TmpBoosting.this.datas[i] = new Data(TmpBoosting.this.specs.size());
/*     */             }
/*     */             
/*  63 */             KeyMap<ArrayListGrower<BoostSpec>> map = new KeyMap();
/*     */             
/*  65 */             for (TmpBoostSpec ts : TmpBoosting.this.specs) {
/*  66 */               for (BoostSpec s : ts.spec.all()) {
/*  67 */                 String k = s.boostable.key + s.boostable.key;
/*  68 */                 if (!map.containsKey(k)) {
/*  69 */                   map.put(k, new ArrayListGrower());
/*     */                 }
/*  71 */                 ((ArrayListGrower)map.get(k)).add(s);
/*     */               } 
/*     */             } 
/*     */             
/*  75 */             for (LIST<BoostSpec> bos : (Iterable<LIST<BoostSpec>>)map.all()) {
/*  76 */               boolean isMul = ((BoostSpec)bos.get(0)).booster.isMul;
/*  77 */               double min = (isMul ? true : false);
/*  78 */               double max = min;
/*     */               
/*  80 */               for (BoostSpec s : bos) {
/*  81 */                 Booster b = s.booster;
/*  82 */                 if (isMul) {
/*  83 */                   if (b.to() < 1.0D) {
/*  84 */                     min *= b.to(); continue;
/*     */                   } 
/*  86 */                   max *= b.to(); continue;
/*     */                 } 
/*  88 */                 if (b.to() < 0.0D) {
/*  89 */                   min += b.to(); continue;
/*     */                 } 
/*  91 */                 max += b.to();
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler prof) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 113 */     file.i(this.specs.size());
/* 114 */     for (TmpBoostSpec s : this.specs) {
/* 115 */       file.chars(s.key);
/*     */     }
/*     */     
/* 118 */     file.i(this.datas.length); byte b; int i; Data[] arrayOfData;
/* 119 */     for (i = (arrayOfData = this.datas).length, b = 0; b < i; ) { Data d = arrayOfData[b];
/* 120 */       d.save(file);
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 129 */     int am = file.i();
/* 130 */     int[] look = Alloc.ii(am);
/* 131 */     Arrays.fill(look, -1); int i;
/* 132 */     for (i = 0; i < am; i++) {
/* 133 */       String k = file.chars();
/* 134 */       if (allMap.containsKey(k)) {
/* 135 */         look[i] = ((TmpBoostSpec)allMap.get(k)).index;
/*     */       }
/*     */     } 
/* 138 */     am = file.i();
/* 139 */     for (i = 0; i < am; i++) {
/* 140 */       if (i < this.datas.length) {
/* 141 */         this.datas[i].load(file, look);
/*     */       } else {
/* 143 */         (new Data(this.specs.size())).load(file, look);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<TmpBoostSpec> specs() {
/* 151 */     return (LIST<TmpBoostSpec>)this.specs;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GBox b, Faction f) {
/* 156 */     for (TmpBoostSpec s : GAME.BOOST().specs()) {
/* 157 */       boolean faction = this.factions.is(f, s);
/* 158 */       int regs = 0;
/* 159 */       for (int ri = 0; ri < f.realm().regions(); ri++) {
/* 160 */         if (this.regions.is(f.realm().region(ri), s))
/* 161 */           regs++; 
/*     */       } 
/* 163 */       boolean pops = false;
/* 164 */       if (f == FACTIONS.player()) {
/* 165 */         for (HCLASS_RACE cl : HCLASS_RACE.ALL()) {
/* 166 */           if (this.popcl.is(cl, s)) {
/* 167 */             pops = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 174 */       if (!faction && regs == 0 && !pops) {
/*     */         continue;
/*     */       }
/* 177 */       b.add(s.icon);
/* 178 */       b.textLL(s.name);
/* 179 */       b.NL();
/* 180 */       b.text(s.desc);
/* 181 */       b.NL(8);
/*     */       
/* 183 */       for (BoostSpec ss : s.spec.all()) {
/* 184 */         b.add((SPRITE)ss.boostable.icon);
/* 185 */         b.textL(ss.boostable.name);
/* 186 */         b.tab(7);
/* 187 */         GText t = b.text();
/* 188 */         if (ss.booster.isMul) {
/* 189 */           t.add('*');
/* 190 */           GFORMAT.f1(t, ss.booster.to());
/*     */         } else {
/* 192 */           GFORMAT.f0(t, ss.booster.to());
/*     */         } 
/* 194 */         b.add((SPRITE)t);
/* 195 */         b.NL();
/*     */       } 
/*     */       
/* 198 */       b.NL(4);
/*     */       
/* 200 */       if (regs > 0) {
/* 201 */         b.textLL(¤¤regs);
/* 202 */         b.add((SPRITE)GFORMAT.i(b.text(), regs));
/* 203 */         b.NL();
/*     */       } 
/*     */       
/* 206 */       if (pops) {
/* 207 */         b.textLL(¤¤groups);
/* 208 */         for (HCLASS_RACE cl : HCLASS_RACE.ALL()) {
/* 209 */           if (cl.race != null && cl.cl != null && this.popcl.is(cl, s)) {
/* 210 */             b.add((SPRITE)(cl.race.appearance()).iconBig);
/* 211 */             b.rewind(8);
/* 212 */             if (cl.cl.iconSmall() == null)
/*     */               continue; 
/* 214 */             b.add((SPRITE)cl.cl.iconSmall());
/* 215 */             b.space();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 220 */       b.sep();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\tmp\TmpBoosting.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */