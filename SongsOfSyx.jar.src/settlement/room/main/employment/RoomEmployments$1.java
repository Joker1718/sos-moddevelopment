/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import init.type.WGROUP;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
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
/*     */ class null
/*     */   implements SAVABLE
/*     */ {
/*     */   public void save(FilePutter file) {
/* 137 */     RoomEmployments.this.history.save(file);
/* 138 */     RoomEmployments.this.equip.saver.save(file);
/*     */     
/* 140 */     file.i(RoomEmployments.this.allS.size());
/* 141 */     for (RoomEmploymentSimple s : RoomEmployments.this.allS) {
/* 142 */       file.chars((s.blueprint()).key);
/* 143 */       int pos = file.getPosition();
/* 144 */       file.i(0);
/* 145 */       s.save(file);
/* 146 */       int le = file.getPosition() - pos - 4;
/* 147 */       file.setAtPosition(pos, le);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 155 */     clear();
/*     */     
/* 157 */     RoomEmployments.this.history.load(file);
/* 158 */     RoomEmployments.this.equip.saver.load(file);
/*     */     
/* 160 */     int am = file.i();
/* 161 */     for (int i = 0; i < am; i++) {
/*     */       
/* 163 */       String k = file.chars();
/*     */       
/* 165 */       RoomBlueprint p = (RoomBlueprint)(SETT.ROOMS()).collection.tryGet(k);
/* 166 */       int skip = file.i();
/* 167 */       if (p == null || p.employment() == null) {
/*     */         
/* 169 */         file.setPosition(file.getPosition() + skip);
/*     */       } else {
/* 171 */         p.employment().load(file);
/*     */       } 
/*     */     } 
/*     */     
/* 175 */     for (RoomEmploymentSimple ss : RoomEmployments.this.allS) {
/*     */       
/* 177 */       if (ss instanceof RoomEmployment) {
/* 178 */         RoomEmployment s = (RoomEmployment)ss;
/* 179 */         for (WGROUP g : WGROUP.all()) {
/* 180 */           RoomEmployments.this.changeCurrent(s.employed(g), g);
/* 181 */           RoomEmployments.this.changeTarget(s.target.group(g), g);
/*     */         } 
/*     */       } 
/* 184 */       RoomEmployments.this.changeNeeded(ss.blueprint(), ss.neededWorkers());
/* 185 */       RoomBlueprintIns<?> blue = ss.blueprint();
/* 186 */       if (blue.employment() != null) {
/* 187 */         for (int j = 0; j < blue.instancesSize(); j++) {
/* 188 */           RoomInstance ins = blue.getInstance(j);
/* 189 */           blue.employment().loadadd(ins.employees());
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 200 */     RoomEmployments.this.needed = 0;
/* 201 */     RoomEmployments.this.current = 0;
/* 202 */     RoomEmployments.this.target = 0; byte b; int i; RoomEmployments.RaceGroup[] arrayOfRaceGroup;
/* 203 */     for (i = (arrayOfRaceGroup = RoomEmployments.this.groups).length, b = 0; b < i; ) { RoomEmployments.RaceGroup g = arrayOfRaceGroup[b];
/* 204 */       g.clear(); b++; }
/* 205 */      Arrays.fill(RoomEmployments.this.searchIS, 0);
/* 206 */     for (RoomEmployment e : RoomEmployments.this.all)
/* 207 */       e.setPrioOnSkill(); 
/* 208 */     RoomEmployments.this.history.clear();
/* 209 */     for (RoomEmploymentSimple s : RoomEmployments.this.allS)
/* 210 */       s.clear(); 
/* 211 */     RoomEmployments.this.equip.saver.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEmployments$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */