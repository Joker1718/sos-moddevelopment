/*     */ package settlement.room.main.construction;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ConstructionHoverer
/*     */   extends UIRoomModule
/*     */ {
/*  33 */   private static CharSequence ¤¤prog = "Construction";
/*  34 */   private static CharSequence ¤¤clear = "Cleared";
/*  35 */   private static CharSequence ¤¤Mat = "Materials";
/*  36 */   private static CharSequence ¤¤Act = "Dormant. Activate to commence work";
/*  37 */   private static CharSequence ¤¤Broken = "The room is broken. You can order your minions to repair it with the repair or activate job tool.";
/*  38 */   private static CharSequence ¤¤resources = "¤This construction needs {0} to complete, which is unobtainable in your city.";
/*     */   
/*     */   static {
/*  41 */     D.ts(ConstructionHoverer.class);
/*     */   }
/*  43 */   private final int[] resNeeded = Alloc.ii(RESOURCES.ALL().size());
/*  44 */   private final int[] resAllocated = Alloc.ii(RESOURCES.ALL().size());
/*     */ 
/*     */ 
/*     */   
/*     */   private final GText t;
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox box, Room r, int rx, int ry) {
/*  53 */     ConstructionInstance k = (ConstructionInstance)r;
/*  54 */     box.clear();
/*  55 */     box.add((SPRITE)(k.constructor().blue()).icon);
/*  56 */     box.textLL(k.name(rx, ry));
/*  57 */     box.NL(8);
/*     */     
/*  59 */     if (!k.active) {
/*  60 */       if (k.broken) {
/*  61 */         box.add((SPRITE)box.text().errorify().add(¤¤Broken));
/*     */       } else {
/*  63 */         box.add((SPRITE)box.text().errorify().add(¤¤Act));
/*     */       } 
/*     */     }
/*     */     
/*  67 */     for (int i = 0; i < k.blueprint.resources(); i++) {
/*  68 */       this.resNeeded[i] = 0;
/*  69 */       this.resAllocated[i] = 0;
/*     */     } 
/*     */     
/*  72 */     int clearNeeded = 0;
/*  73 */     int floorNeeded = 0;
/*  74 */     int structuresNeeded = 0;
/*  75 */     int structureResources = 0;
/*  76 */     int itemNeeded = 0;
/*  77 */     int itemTotal = 0;
/*     */     
/*  79 */     for (COORDINATE c : k.body()) {
/*  80 */       if (!k.is(c))
/*     */         continue; 
/*  82 */       if (k.needsClear(c))
/*  83 */         clearNeeded++; 
/*  84 */       if (k.structureI >= 0 && !(SETT.TERRAIN()).CAVE.is(c) && !(SETT.TERRAIN()).MOUNTAIN.isMountain(c.x(), c.y()) && !((TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(k.structureI)).roof.is(c)) {
/*  85 */         structuresNeeded++;
/*  86 */         structureResources += ConstructionData.dWorkAmount.get(c);
/*     */       } 
/*  88 */       if (ConstructionData.dFloored.is(c, 0))
/*  89 */         floorNeeded++; 
/*  90 */       FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(c);
/*  91 */       if (it != null)
/*  92 */         itemTotal++; 
/*  93 */       if (it != null && (ConstructionData.dConstructed.is(c, 0) || ConstructionData.dBroken.is(c, 1))) {
/*  94 */         itemNeeded++;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  99 */       (SETT.ROOMS()).fData.isMaster.is(c);
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
/* 112 */       int am = ConstructionData.dResAllocated.get(c);
/* 113 */       for (int m = 0; m < k.blueprint.resources(); m++) {
/* 114 */         int b = ConstructionData.dResourceNeeded[m].get(c);
/* 115 */         this.resNeeded[m] = this.resNeeded[m] + b;
/* 116 */         if (am > 0) {
/* 117 */           int a = CLAMP.i(am, 0, b);
/* 118 */           this.resAllocated[m] = this.resAllocated[m] + a;
/* 119 */           am -= a;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 125 */     box.NL();
/* 126 */     box.textLL(¤¤clear);
/* 127 */     box.tab(5);
/* 128 */     box.add((SPRITE)GFORMAT.perc(box.text(), (k.area() - clearNeeded) / k.area(), 1));
/*     */     
/* 130 */     box.NL();
/* 131 */     box.textLL(¤¤Mat);
/* 132 */     box.tab(5);
/*     */     
/* 134 */     if (k.structureI >= 0) {
/* 135 */       RESOURCE sRes = ((TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(k.structureI)).structure.resource;
/* 136 */       int sResA = ((TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(k.structureI)).structure.resAmount;
/* 137 */       int kkkk = -1;
/* 138 */       for (int m = 0; m < k.blueprint.resources(); m++) {
/* 139 */         if (k.blueprint.resource(m) == sRes) {
/* 140 */           kkkk = m;
/* 141 */           this.resAllocated[m] = this.resAllocated[m] + structureResources;
/* 142 */           this.resAllocated[m] = this.resAllocated[m] + (k.area() - structuresNeeded) * sResA;
/* 143 */           this.resNeeded[m] = this.resNeeded[m] + k.area() * sResA;
/*     */         } 
/*     */       } 
/*     */       
/* 147 */       if (kkkk == -1 && sRes != null && structuresNeeded > 0) {
/* 148 */         box.setResource(sRes, structureResources + (k.area() - structuresNeeded) * sResA, k.area() * sResA);
/*     */       }
/*     */     } 
/*     */     int j;
/* 152 */     for (j = 0; j < k.blueprint.resources(); j++) {
/* 153 */       if (this.resNeeded[j] > 0) {
/* 154 */         RESOURCE res = k.blueprint.resource(j);
/* 155 */         box.setResource(res, this.resAllocated[j], this.resNeeded[j]);
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     box.NL();
/*     */     
/* 161 */     for (j = 0; j < k.blueprint.resources(); j++) {
/* 162 */       if (this.resNeeded[j] > 0 && this.resAllocated[j] < this.resNeeded[j] && !(SETT.PATH()).finders.resource.has(rx, ry, (k.blueprint.resource(j)).bit)) {
/* 163 */         RESOURCE res = k.blueprint.resource(j);
/* 164 */         GText gText = box.text();
/* 165 */         gText.add(¤¤resources);
/* 166 */         gText.insert(0, res.names);
/* 167 */         gText.errorify();
/* 168 */         if (res.specialHelpText != null) {
/* 169 */           gText.s().add(res.specialHelpText);
/*     */         }
/* 171 */         box.add((res.icon()).big);
/* 172 */         box.add((SPRITE)gText);
/* 173 */         box.NL();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 179 */     box.NL();
/*     */ 
/*     */ 
/*     */     
/* 183 */     box.NL();
/* 184 */     box.textLL(¤¤prog);
/* 185 */     box.tab(5);
/* 186 */     double total = (k.area() + itemTotal);
/* 187 */     double p = (floorNeeded + k.builtNeeded);
/* 188 */     double t = (total - p) / total;
/* 189 */     box.add((SPRITE)GFORMAT.perc(box.text(), t));
/*     */     
/* 191 */     box.NL();
/*     */ 
/*     */ 
/*     */     
/* 195 */     if ((S.get()).developer) {
/* 196 */       box.NL();
/* 197 */       k.debug(box);
/* 198 */       box.NL(); box.NL();
/* 199 */       box.add((SPRITE)box.text().add("nClear: ").add(clearNeeded));
/* 200 */       box.add((SPRITE)box.text().add("nFloor: ").add(floorNeeded));
/* 201 */       box.add((SPRITE)box.text().add("nStruc: ").add(structuresNeeded));
/* 202 */       box.add((SPRITE)box.text().add("nItem: ").add(itemNeeded).add('/').add(itemTotal));
/*     */       
/* 204 */       Job job = (Job)(SETT.JOBS()).getter.get((COORDINATE)VIEW.s().getWindow().tile());
/* 205 */       if (job != null) {
/* 206 */         box.NL(8);
/* 207 */         job.hover(box);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public ConstructionHoverer() {
/* 213 */     this.t = new GText((UI.FONT()).M, 16);
/*     */   }
/*     */   
/*     */   void renderButt(ConstructionInstance k, SPRITE_RENDERER r, int x1, int cy) {
/* 217 */     k.icon().renderCY(r, x1, cy);
/*     */ 
/*     */     
/* 220 */     int clearNeeded = 0;
/* 221 */     int floorNeeded = 0;
/* 222 */     int structNeeded = 0;
/* 223 */     int itemTotal = 0;
/*     */     
/* 225 */     for (COORDINATE c : k.body()) {
/* 226 */       if (!k.is(c))
/*     */         continue; 
/* 228 */       if (k.needsClear(c))
/* 229 */         clearNeeded++; 
/* 230 */       if (k.structureI >= 0 && !(SETT.TERRAIN()).CAVE.is(c) && !(SETT.TERRAIN()).MOUNTAIN.isMountain(c.x(), c.y()) && !((TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(k.structureI)).roof.is(c)) {
/* 231 */         structNeeded++;
/*     */       }
/* 233 */       if (ConstructionData.dFloored.is(c, 0)) {
/* 234 */         floorNeeded++;
/*     */       }
/* 236 */       FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(c);
/* 237 */       if (it != null) {
/* 238 */         itemTotal++;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 247 */     double total = (k.area() + k.area() + itemTotal);
/* 248 */     double p = (floorNeeded + k.builtNeeded + clearNeeded);
/* 249 */     if (k.structureI >= 0) {
/* 250 */       total += k.area();
/* 251 */       p += structNeeded;
/*     */     } 
/* 253 */     double prog = (total - p) / total;
/*     */ 
/*     */     
/* 256 */     this.t.clear();
/* 257 */     GFORMAT.percGood(this.t, prog);
/*     */     
/* 259 */     if (!k.active) {
/* 260 */       this.t.errorify();
/*     */     }
/* 262 */     this.t.renderCY(r, x1 + 32 + 8, cy);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\construction\ConstructionHoverer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */