package META-INF.versions.25.org.lwjgl.system;

import java.lang.foreign.MemorySegment;
import org.lwjgl.system.ffm.FFMFunctionAddress;
import org.lwjgl.system.ffm.FFMNullable;
import org.lwjgl.system.ffm.FFMPointer;

@FFMFunctionAddress
interface JNIBindings {
  byte invokePB(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  short invokeC(MemorySegment paramMemorySegment);
  
  short invokeC(MemorySegment paramMemorySegment, int paramInt);
  
  short invokePC(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  short invokeCC(MemorySegment paramMemorySegment, int paramInt, short paramShort);
  
  short invokeCC(MemorySegment paramMemorySegment, short paramShort, boolean paramBoolean);
  
  short invokePC(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  short invokeJC(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, long paramLong);
  
  short invokeCUC(MemorySegment paramMemorySegment, short paramShort, byte paramByte);
  
  short invokePCC(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort);
  
  short invokeCCC(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, boolean paramBoolean);
  
  short invokePCC(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong, short paramShort);
  
  short invokePCC(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, short paramShort);
  
  short invokeUPC(MemorySegment paramMemorySegment, byte paramByte, @FFMNullable @FFMPointer long paramLong, boolean paramBoolean);
  
  short invokePCC(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, short paramShort);
  
  short invokeCJC(MemorySegment paramMemorySegment, int paramInt1, boolean paramBoolean, short paramShort, int paramInt2, long paramLong);
  
  short invokeCPCC(MemorySegment paramMemorySegment, short paramShort1, @FFMNullable @FFMPointer long paramLong, short paramShort2);
  
  short invokeCPPC(MemorySegment paramMemorySegment, short paramShort, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  short invokePPCC(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, short paramShort);
  
  short invokeCCJC(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, int paramInt, long paramLong);
  
  short invokePCCC(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, short paramShort2, int paramInt1, int paramInt2);
  
  short invokeCCCCC(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3, short paramShort4);
  
  short invokePJUPC(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, byte paramByte, @FFMNullable @FFMPointer long paramLong3);
  
  short invokeCCJPC(MemorySegment paramMemorySegment, short paramShort1, boolean paramBoolean, short paramShort2, int paramInt, long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  short invokePCCCCC(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, short paramShort2, short paramShort3, short paramShort4);
  
  short invokeCCCJPC(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3, boolean paramBoolean, int paramInt, long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  short invokeCCCJPC(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, boolean paramBoolean, short paramShort3, int paramInt, long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  double invokeD(MemorySegment paramMemorySegment);
  
  double invokeD(MemorySegment paramMemorySegment, int paramInt);
  
  double invokePD(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  double invokePD(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  double invokePD(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2);
  
  double invokePPD(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  float invokeF(MemorySegment paramMemorySegment);
  
  float invokeF(MemorySegment paramMemorySegment, int paramInt);
  
  float invokePF(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  float invokePF(MemorySegment paramMemorySegment, float paramFloat, @FFMNullable @FFMPointer long paramLong);
  
  float invokePF(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  float invokePF(MemorySegment paramMemorySegment, float paramFloat1, float paramFloat2, @FFMNullable @FFMPointer long paramLong);
  
  float invokePF(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong, float paramFloat);
  
  float invokePF(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, float paramFloat2);
  
  float invokePF(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2);
  
  float invokePPF(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  float invokePPF(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2);
  
  float invokePPF(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, float paramFloat, @FFMNullable @FFMPointer long paramLong2, int paramInt);
  
  int invokeI(MemorySegment paramMemorySegment);
  
  int invokeI(MemorySegment paramMemorySegment, int paramInt);
  
  int invokeI(MemorySegment paramMemorySegment, boolean paramBoolean);
  
  int invokeI(MemorySegment paramMemorySegment, int paramInt, float paramFloat);
  
  int invokeI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2);
  
  int invokeI(MemorySegment paramMemorySegment, int paramInt, boolean paramBoolean);
  
  int invokeI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3);
  
  int invokeI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  int invokeI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  int invokeI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  int invokeJI(MemorySegment paramMemorySegment, long paramLong);
  
  int invokePI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  int invokeCI(MemorySegment paramMemorySegment, int paramInt, short paramShort);
  
  int invokePI(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong);
  
  int invokePI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  int invokePI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, boolean paramBoolean);
  
  int invokeCI(MemorySegment paramMemorySegment, int paramInt, short paramShort, boolean paramBoolean);
  
  int invokePI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2);
  
  int invokePI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, boolean paramBoolean);
  
  int invokePI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  int invokePI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  int invokePI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  int invokeCPI(MemorySegment paramMemorySegment, short paramShort, @FFMNullable @FFMPointer long paramLong);
  
  int invokePCI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort);
  
  int invokePJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  int invokePNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  int invokePJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt);
  
  int invokePNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2);
  
  int invokePNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt);
  
  int invokePPI(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, float paramFloat);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, boolean paramBoolean);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, boolean paramBoolean, @FFMNullable @FFMPointer long paramLong2);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, boolean paramBoolean);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, boolean paramBoolean, @FFMNullable @FFMPointer long paramLong2);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, boolean paramBoolean1, boolean paramBoolean2);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong2);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, int paramInt3);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, int paramInt3);
  
  int invokePPI(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, int paramInt3, boolean paramBoolean);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong2);
  
  int invokePPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong2, int paramInt5);
  
  int invokeCPUI(MemorySegment paramMemorySegment, short paramShort, @FFMNullable @FFMPointer long paramLong, byte paramByte);
  
  int invokeJPPI(MemorySegment paramMemorySegment, long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int invokePCPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort, @FFMNullable @FFMPointer long paramLong2);
  
  int invokePNNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3);
  
  int invokePNPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int invokePPCI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, short paramShort);
  
  int invokePPJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3);
  
  int invokePPNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int invokePNPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3);
  
  int invokePNPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt);
  
  int invokePPNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, long paramLong3);
  
  int invokePPPI(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt);
  
  int invokePNNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3, int paramInt3);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2, int paramInt3);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2, int paramInt3);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, boolean paramBoolean, float paramFloat);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt4);
  
  int invokePPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, int paramInt3, @FFMNullable @FFMPointer long paramLong3, int paramInt4, int paramInt5);
  
  int invokePNPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int invokePPNNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, long paramLong4);
  
  int invokePPNPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int invokePPPNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int invokePUUUI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte1, byte paramByte2, byte paramByte3);
  
  int invokePNNPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt, long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int invokePPPNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, long paramLong4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt2);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, int paramInt2);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt3);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3, int paramInt3, @FFMNullable @FFMPointer long paramLong4, int paramInt4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong4, int paramInt4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  int invokePPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, int paramInt3, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt4, int paramInt5);
  
  int invokePNNPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPNNPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPNNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4, long paramLong5);
  
  int invokePPPPNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, long paramLong5);
  
  int invokePPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPUUUI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, byte paramByte1, byte paramByte2, byte paramByte3);
  
  int invokePUUUUI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4);
  
  int invokePJPPNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, long paramLong5);
  
  int invokePPNPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPNPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPNJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4, long paramLong5);
  
  int invokePPPNNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4, long paramLong5);
  
  int invokePPPNPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPPNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, long paramLong5);
  
  int invokePPPPNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, long paramLong5);
  
  int invokePPPPPI(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt);
  
  int invokePNPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4, int paramInt3, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, @FFMNullable @FFMPointer long paramLong4, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2, int paramInt3, float paramFloat, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int invokePPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int invokePPUUUUI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4);
  
  int invokePJJJJPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, @FFMNullable @FFMPointer long paramLong6);
  
  int invokePPNPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int invokePPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int invokePPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, int paramInt);
  
  int invokePNNPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int invokePPPPPPI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int invokePPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int invokePPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4, int paramInt3, @FFMNullable @FFMPointer long paramLong5, int paramInt4, @FFMNullable @FFMPointer long paramLong6);
  
  int invokePPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  int invokePPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  int invokePPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4, float paramFloat1, float paramFloat2, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  int invokePPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt3, @FFMNullable @FFMPointer long paramLong6, int paramInt4, @FFMNullable @FFMPointer long paramLong7, int paramInt5);
  
  int invokePPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8);
  
  long invokeJ(MemorySegment paramMemorySegment);
  
  long invokeJ(MemorySegment paramMemorySegment, int paramInt1, int paramInt2);
  
  long invokePJ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  long invokePJ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  long invokePJ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2);
  
  long invokePJJ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  long invokePPJ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  long invokePJJ(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  long invokePJJ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2);
  
  long invokePJJ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt);
  
  long invokePPJ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt);
  
  long invokeNN(MemorySegment paramMemorySegment, long paramLong);
  
  long invokePN(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  long invokePN(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  long invokeNNN(MemorySegment paramMemorySegment, long paramLong1, long paramLong2);
  
  long invokePPN(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  long invokeNNNN(MemorySegment paramMemorySegment, long paramLong1, long paramLong2, long paramLong3);
  
  long invokePNPN(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  long invokePNPN(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt);
  
  long invokePPNN(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, long paramLong3);
  
  long invokePNPNN(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4);
  
  long invokePNPNPN(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, @FFMNullable @FFMPointer long paramLong3, long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long invokeP(MemorySegment paramMemorySegment);
  
  @FFMPointer
  long invokeP(MemorySegment paramMemorySegment, int paramInt);
  
  @FFMPointer
  long invokeP(MemorySegment paramMemorySegment, boolean paramBoolean);
  
  @FFMPointer
  long invokeP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2);
  
  @FFMPointer
  long invokeP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3);
  
  @FFMPointer
  long invokeCP(MemorySegment paramMemorySegment, short paramShort);
  
  @FFMPointer
  long invokeJP(MemorySegment paramMemorySegment, long paramLong);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, double paramDouble);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, boolean paramBoolean);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, int paramInt, boolean paramBoolean, @FFMNullable @FFMPointer long paramLong);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong, int paramInt4);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, int paramInt1, float paramFloat2, int paramInt2);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @FFMPointer
  long invokePP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  @FFMPointer
  long invokeCCP(MemorySegment paramMemorySegment, short paramShort1, short paramShort2);
  
  @FFMPointer
  long invokeJPP(MemorySegment paramMemorySegment, long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long invokePJP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  @FFMPointer
  long invokePNP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long invokePUP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte);
  
  @FFMPointer
  long invokeCPP(MemorySegment paramMemorySegment, int paramInt, short paramShort, @FFMNullable @FFMPointer long paramLong);
  
  @FFMPointer
  long invokePCP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort, boolean paramBoolean);
  
  @FFMPointer
  long invokePJP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2);
  
  @FFMPointer
  long invokePJP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, boolean paramBoolean);
  
  @FFMPointer
  long invokePJP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, boolean paramBoolean1, boolean paramBoolean2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, boolean paramBoolean1, boolean paramBoolean2, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, int paramInt3);
  
  @FFMPointer
  long invokePJP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @FFMPointer
  long invokePUP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, byte paramByte, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  
  @FFMPointer
  long invokePPP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong1, int paramInt5, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long invokeCCPP(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, @FFMNullable @FFMPointer long paramLong);
  
  @FFMPointer
  long invokeCPCP(MemorySegment paramMemorySegment, short paramShort1, @FFMNullable @FFMPointer long paramLong, short paramShort2);
  
  @FFMPointer
  long invokePJJP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3);
  
  @FFMPointer
  long invokePPJP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long invokePPUP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, byte paramByte);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, boolean paramBoolean, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long invokePPUP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, byte paramByte);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2);
  
  @FFMPointer
  long invokeJPPP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2, int paramInt3);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3, int paramInt3);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt4, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long invokePPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3, int paramInt3, int paramInt4);
  
  @FFMPointer
  long invokePBPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, byte paramByte, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long invokePNNPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long invokePPJPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long invokePPNNP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, long paramLong4);
  
  @FFMPointer
  long invokePPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long invokePPPJP(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4);
  
  @FFMPointer
  long invokePPPJP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4, int paramInt);
  
  @FFMPointer
  long invokePPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long invokePPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long invokePPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long invokePPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt);
  
  @FFMPointer
  long invokePJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long invokePJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt2);
  
  @FFMPointer
  long invokePPPJP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4, int paramInt1, int paramInt2);
  
  @FFMPointer
  long invokePPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long invokePPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, @FFMNullable @FFMPointer long paramLong4, int paramInt2);
  
  @FFMPointer
  long invokePPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long invokePPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, @FFMNullable @FFMPointer long paramLong4, int paramInt2, int paramInt3);
  
  @FFMPointer
  long invokePPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, int paramInt2, int paramInt3);
  
  @FFMPointer
  long invokePPPPP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt4, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long invokePJPJPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long invokePNNNPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long invokePPBPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, byte paramByte, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long invokePPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long invokeCCCUJP(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3, byte paramByte, int paramInt, long paramLong);
  
  @FFMPointer
  long invokePPPJPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt);
  
  @FFMPointer
  long invokePPPPNP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, long paramLong5);
  
  @FFMPointer
  long invokePPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long invokePPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long invokePPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt);
  
  @FFMPointer
  long invokePPJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long invokePPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, @FFMNullable @FFMPointer long paramLong4, int paramInt2, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long invokePPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, @FFMNullable @FFMPointer long paramLong5, int paramInt2);
  
  @FFMPointer
  long invokePPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, int paramInt2);
  
  @FFMPointer
  long invokePPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @FFMPointer
  long invokePPJJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  @FFMPointer
  long invokePPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  @FFMPointer
  long invokePSSCCPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, short paramShort2, short paramShort3, short paramShort4, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long invokePPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  @FFMPointer
  long invokePPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  @FFMPointer
  long invokePPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, int paramInt);
  
  @FFMPointer
  long invokePPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  @FFMPointer
  long invokePPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, @FFMNullable @FFMPointer long paramLong4, int paramInt2, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  @FFMPointer
  long invokePPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, @FFMNullable @FFMPointer long paramLong5, int paramInt2, @FFMNullable @FFMPointer long paramLong6);
  
  @FFMPointer
  long invokePPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, @FFMNullable @FFMPointer long paramLong6, int paramInt2);
  
  @FFMPointer
  long invokePPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, @FFMNullable @FFMPointer long paramLong5, int paramInt2, @FFMNullable @FFMPointer long paramLong6, int paramInt3, int paramInt4);
  
  @FFMPointer
  long invokePPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, @FFMNullable @FFMPointer long paramLong6, int paramInt2, int paramInt3, int paramInt4);
  
  @FFMPointer
  long invokePPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  @FFMPointer
  long invokePPPPPJPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, long paramLong6, int paramInt2, @FFMNullable @FFMPointer long paramLong7);
  
  @FFMPointer
  long invokePPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, int paramInt2);
  
  @FFMPointer
  long invokePPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, @FFMNullable @FFMPointer long paramLong6, int paramInt2, @FFMNullable @FFMPointer long paramLong7, int paramInt3);
  
  @FFMPointer
  long invokePPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8);
  
  @FFMPointer
  long invokePPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, int paramInt, @FFMNullable @FFMPointer long paramLong8);
  
  @FFMPointer
  long invokePPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, int paramInt2, @FFMNullable @FFMPointer long paramLong8);
  
  @FFMPointer
  long invokePPPPJJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, long paramLong5, int paramInt2, long paramLong6, int paramInt3, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8);
  
  @FFMPointer
  long invokePPPPPJJPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, long paramLong6, int paramInt2, long paramLong7, int paramInt3, @FFMNullable @FFMPointer long paramLong8);
  
  @FFMPointer
  long invokePPPPPJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, long paramLong6, int paramInt2, @FFMNullable @FFMPointer long paramLong7, int paramInt3, @FFMNullable @FFMPointer long paramLong8);
  
  @FFMPointer
  long invokePPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, @FFMNullable @FFMPointer long paramLong6, int paramInt2, @FFMNullable @FFMPointer long paramLong7, int paramInt3, @FFMNullable @FFMPointer long paramLong8);
  
  @FFMPointer
  long invokePPPPPJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt2, int paramInt3, long paramLong6, int paramInt4, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8);
  
  @FFMPointer
  long invokePPPPPJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt2, int paramInt3, long paramLong6, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8);
  
  @FFMPointer
  long invokePPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, int paramInt1, @FFMNullable @FFMPointer long paramLong8, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  @FFMPointer
  long invokePPPPPJJJPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, long paramLong6, long paramLong7, long paramLong8, int paramInt2, @FFMNullable @FFMPointer long paramLong9);
  
  @FFMPointer
  long invokePPPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, int paramInt2, @FFMNullable @FFMPointer long paramLong9);
  
  @FFMPointer
  long invokePPPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, int paramInt1, @FFMNullable @FFMPointer long paramLong8, int paramInt2, @FFMNullable @FFMPointer long paramLong9, int paramInt3);
  
  @FFMPointer
  long invokePPPPPJPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, long paramLong6, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong7, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9);
  
  @FFMPointer
  long invokePPPPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10);
  
  @FFMPointer
  long invokePPPPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, int paramInt1, @FFMNullable @FFMPointer long paramLong8, int paramInt2, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10, int paramInt3);
  
  @FFMPointer
  long invokePPPPPJPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, @FFMNullable @FFMPointer long paramLong5, long paramLong6, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10, @FFMNullable @FFMPointer long paramLong11);
  
  @FFMPointer
  long invokePPPPPJPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, long paramLong6, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10, @FFMNullable @FFMPointer long paramLong11);
  
  @FFMPointer
  long invokePPPPPPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt2, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, int paramInt3, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, int paramInt4, int paramInt5, int paramInt6, int paramInt7, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10, @FFMNullable @FFMPointer long paramLong11, @FFMNullable @FFMPointer long paramLong12);
  
  @FFMPointer
  long invokePPPPPJPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, @FFMNullable @FFMPointer long paramLong5, long paramLong6, int paramInt2, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, int paramInt3, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10, @FFMNullable @FFMPointer long paramLong11, @FFMNullable @FFMPointer long paramLong12, @FFMNullable @FFMPointer long paramLong13);
  
  @FFMPointer
  long invokePPPPPJJPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, long paramLong6, int paramInt2, long paramLong7, int paramInt3, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9, int paramInt4, @FFMNullable @FFMPointer long paramLong10, @FFMNullable @FFMPointer long paramLong11, @FFMNullable @FFMPointer long paramLong12, @FFMNullable @FFMPointer long paramLong13);
  
  short invokePS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  byte invokeU(MemorySegment paramMemorySegment, int paramInt);
  
  byte invokePU(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  byte invokeUPU(MemorySegment paramMemorySegment, byte paramByte, @FFMNullable @FFMPointer long paramLong);
  
  void invokeV(MemorySegment paramMemorySegment);
  
  void invokeV(MemorySegment paramMemorySegment, double paramDouble);
  
  void invokeV(MemorySegment paramMemorySegment, float paramFloat);
  
  void invokeV(MemorySegment paramMemorySegment, int paramInt);
  
  void invokeV(MemorySegment paramMemorySegment, boolean paramBoolean);
  
  void invokeV(MemorySegment paramMemorySegment, int paramInt, float paramFloat);
  
  void invokeV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2);
  
  void invokeV(MemorySegment paramMemorySegment, int paramInt, boolean paramBoolean);
  
  void invokeV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, double paramDouble);
  
  void invokeV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, float paramFloat);
  
  void invokeV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3);
  
  void invokeV(MemorySegment paramMemorySegment, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  
  void invokeV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  void invokeV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3);
  
  void invokeV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3);
  
  void invokeV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  void invokeCV(MemorySegment paramMemorySegment, short paramShort);
  
  void invokeJV(MemorySegment paramMemorySegment, long paramLong);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  void invokeUV(MemorySegment paramMemorySegment, byte paramByte);
  
  void invokeCV(MemorySegment paramMemorySegment, int paramInt, short paramShort);
  
  void invokeCV(MemorySegment paramMemorySegment, short paramShort, int paramInt);
  
  void invokeCV(MemorySegment paramMemorySegment, short paramShort, boolean paramBoolean);
  
  void invokeJV(MemorySegment paramMemorySegment, int paramInt, long paramLong);
  
  void invokeJV(MemorySegment paramMemorySegment, long paramLong, int paramInt);
  
  void invokePV(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, boolean paramBoolean);
  
  void invokeUV(MemorySegment paramMemorySegment, byte paramByte, int paramInt);
  
  void invokeUV(MemorySegment paramMemorySegment, byte paramByte, boolean paramBoolean);
  
  void invokeCV(MemorySegment paramMemorySegment, short paramShort, int paramInt1, int paramInt2);
  
  void invokeJV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, long paramLong);
  
  void invokePV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong);
  
  void invokePV(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong, boolean paramBoolean);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, double paramDouble1, double paramDouble2);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, float paramFloat2);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, double paramDouble);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, float paramFloat);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, boolean paramBoolean);
  
  void invokePV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, float paramFloat2, int paramInt);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, double paramDouble);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, float paramFloat);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  void invokePV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong, int paramInt3, int paramInt4);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  void invokeUV(MemorySegment paramMemorySegment, byte paramByte, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  void invokePV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong);
  
  void invokePV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong, boolean paramBoolean);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  void invokePV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  void invokePV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, @FFMNullable @FFMPointer long paramLong);
  
  void invokeCCV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2);
  
  void invokeCPV(MemorySegment paramMemorySegment, short paramShort, @FFMNullable @FFMPointer long paramLong);
  
  void invokePCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort);
  
  void invokePJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  void invokePNV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void invokePUV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte);
  
  void invokeUPV(MemorySegment paramMemorySegment, byte paramByte, @FFMNullable @FFMPointer long paramLong);
  
  void invokeCPV(MemorySegment paramMemorySegment, short paramShort, int paramInt, @FFMNullable @FFMPointer long paramLong);
  
  void invokeCPV(MemorySegment paramMemorySegment, short paramShort, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  void invokePCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, short paramShort);
  
  void invokePCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort, boolean paramBoolean);
  
  void invokePJV(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  void invokePJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2);
  
  void invokePJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt);
  
  void invokePPV(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, float paramFloat);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, boolean paramBoolean);
  
  void invokeUCV(MemorySegment paramMemorySegment, byte paramByte, short paramShort, int paramInt);
  
  void invokePBV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, byte paramByte);
  
  void invokePCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, short paramShort);
  
  void invokePCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort, int paramInt1, int paramInt2);
  
  void invokePJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  void invokePPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void invokePPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, boolean paramBoolean);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2);
  
  void invokePSV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, short paramShort);
  
  void invokePUV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, byte paramByte);
  
  void invokeUCV(MemorySegment paramMemorySegment, byte paramByte, short paramShort, int paramInt1, int paramInt2);
  
  void invokeUPV(MemorySegment paramMemorySegment, byte paramByte, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2);
  
  void invokePCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort, int paramInt1, int paramInt2, int paramInt3);
  
  void invokePPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, float paramFloat, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3);
  
  void invokePPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, int paramInt3, int paramInt4);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  void invokePPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong2);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong2, boolean paramBoolean);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  void invokePPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  void invokeCCPV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, @FFMNullable @FFMPointer long paramLong);
  
  void invokeCPCV(MemorySegment paramMemorySegment, short paramShort1, @FFMNullable @FFMPointer long paramLong, short paramShort2);
  
  void invokeCPPV(MemorySegment paramMemorySegment, short paramShort, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void invokeJPPV(MemorySegment paramMemorySegment, long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePNNV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3);
  
  void invokePNPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPNV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void invokeCCCV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3, int paramInt);
  
  void invokeCCUV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, int paramInt, byte paramByte);
  
  void invokePJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt);
  
  void invokePPJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, float paramFloat);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, boolean paramBoolean);
  
  void invokePUCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte, short paramShort, int paramInt);
  
  void invokeUCCV(MemorySegment paramMemorySegment, byte paramByte, short paramShort1, short paramShort2, int paramInt);
  
  void invokeCCUV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, int paramInt, float paramFloat, byte paramByte);
  
  void invokeJJJV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
  
  void invokePNNV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, float paramFloat1, float paramFloat2);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, boolean paramBoolean);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, boolean paramBoolean1, boolean paramBoolean2);
  
  void invokePUCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte, short paramShort, int paramInt1, int paramInt2);
  
  void invokePUPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, byte paramByte, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2);
  
  void invokeUCCV(MemorySegment paramMemorySegment, byte paramByte, short paramShort1, int paramInt1, int paramInt2, short paramShort2);
  
  void invokeUCUV(MemorySegment paramMemorySegment, byte paramByte1, short paramShort, byte paramByte2, int paramInt1, int paramInt2);
  
  void invokeUPCV(MemorySegment paramMemorySegment, byte paramByte, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, short paramShort);
  
  void invokeCCUV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, int paramInt1, int paramInt2, int paramInt3, byte paramByte);
  
  void invokePPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, int paramInt3, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3, int paramInt3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2, int paramInt3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, boolean paramBoolean, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, int paramInt3, @FFMNullable @FFMPointer long paramLong3, int paramInt4);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3, int paramInt3, int paramInt4);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong3, int paramInt4, boolean paramBoolean);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  void invokeCCPCV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, @FFMNullable @FFMPointer long paramLong, short paramShort3);
  
  void invokeCCUPV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, byte paramByte, @FFMNullable @FFMPointer long paramLong);
  
  void invokePCPCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, @FFMNullable @FFMPointer long paramLong2, short paramShort2);
  
  void invokePNPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void invokePPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void invokeCCCUV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3, int paramInt, byte paramByte);
  
  void invokePCCUV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, short paramShort2, int paramInt, byte paramByte);
  
  void invokePJJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void invokePPCPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, short paramShort, int paramInt, @FFMNullable @FFMPointer long paramLong3);
  
  void invokePPPCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, short paramShort);
  
  void invokePPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void invokePPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void invokePPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4);
  
  void invokePPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt);
  
  void invokePPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, boolean paramBoolean);
  
  void invokePUCCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte, short paramShort1, short paramShort2, int paramInt);
  
  void invokeCCCUV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3, int paramInt1, int paramInt2, byte paramByte);
  
  void invokePJJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4);
  
  void invokePPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void invokePPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, float paramFloat1, float paramFloat2, @FFMNullable @FFMPointer long paramLong4);
  
  void invokePUCCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte, short paramShort1, int paramInt1, int paramInt2, short paramShort2);
  
  void invokePUCUV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte1, short paramShort, byte paramByte2, int paramInt1, int paramInt2);
  
  void invokePUPCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, byte paramByte, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, short paramShort);
  
  void invokeCCCUV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3, int paramInt1, int paramInt2, int paramInt3, byte paramByte);
  
  void invokePCCUV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, short paramShort2, int paramInt1, int paramInt2, int paramInt3, byte paramByte);
  
  void invokePPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @FFMNullable @FFMPointer long paramLong4);
  
  void invokePPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2, int paramInt3, float paramFloat, @FFMNullable @FFMPointer long paramLong4);
  
  void invokePPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, @FFMNullable @FFMPointer long paramLong4);
  
  void invokeCCCCCV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5);
  
  void invokeCCUPPV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, byte paramByte, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void invokePPCPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, short paramShort, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void invokePPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  void invokePCCCUV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, short paramShort2, short paramShort3, int paramInt, byte paramByte);
  
  void invokePJPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  void invokePPPPPV(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  void invokePPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  void invokePPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  void invokePPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt, @FFMNullable @FFMPointer long paramLong5);
  
  void invokePCCCUV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, short paramShort2, short paramShort3, int paramInt1, int paramInt2, byte paramByte);
  
  void invokePPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  void invokePPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt, @FFMNullable @FFMPointer long paramLong5, boolean paramBoolean);
  
  void invokePCCCCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, short paramShort2, short paramShort3, boolean paramBoolean1, boolean paramBoolean2, short paramShort4, int paramInt);
  
  void invokePCCCUV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, short paramShort2, short paramShort3, int paramInt1, int paramInt2, int paramInt3, byte paramByte);
  
  void invokePPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4, int paramInt3, @FFMNullable @FFMPointer long paramLong5);
  
  void invokePPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong5);
  
  void invokeCCCCUV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3, int paramInt1, short paramShort4, int paramInt2, int paramInt3, int paramInt4, byte paramByte);
  
  void invokePPPPPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt3, @FFMNullable @FFMPointer long paramLong5, int paramInt4, boolean paramBoolean);
  
  void invokeCCCCPCV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3, short paramShort4, @FFMNullable @FFMPointer long paramLong, short paramShort5);
  
  void invokePPPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  void invokePCCCCUV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, int paramInt, short paramShort2, short paramShort3, short paramShort4, byte paramByte);
  
  void invokePPPPPPV(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  void invokePCCCCUV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, short paramShort2, short paramShort3, int paramInt1, short paramShort4, int paramInt2, int paramInt3, int paramInt4, byte paramByte);
  
  void invokePPPPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  void invokePPPPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  void invokeCCUCCCCPCV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, byte paramByte, short paramShort3, short paramShort4, short paramShort5, short paramShort6, @FFMNullable @FFMPointer long paramLong, short paramShort7);
  
  void invokeCUCCCCCCPV(MemorySegment paramMemorySegment, short paramShort1, byte paramByte, short paramShort2, short paramShort3, short paramShort4, short paramShort5, short paramShort6, short paramShort7, @FFMNullable @FFMPointer long paramLong);
  
  void invokeCCUUCCCCPCV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, byte paramByte1, byte paramByte2, short paramShort3, short paramShort4, short paramShort5, short paramShort6, @FFMNullable @FFMPointer long paramLong, short paramShort7);
  
  void invokeCCUUUUUUUUUV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, float paramFloat, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8, byte paramByte9);
  
  void invokeCCUCCCCUCCCCCCV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, byte paramByte1, short paramShort3, short paramShort4, short paramShort5, short paramShort6, byte paramByte2, short paramShort7, short paramShort8, short paramShort9, short paramShort10, short paramShort11, short paramShort12);
  
  void invokePCCUCCCCUCCCCCCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, short paramShort2, byte paramByte1, short paramShort3, short paramShort4, short paramShort5, short paramShort6, byte paramByte2, short paramShort7, short paramShort8, short paramShort9, short paramShort10, short paramShort11, short paramShort12);
  
  boolean invokeZ(MemorySegment paramMemorySegment);
  
  boolean invokeZ(MemorySegment paramMemorySegment, int paramInt);
  
  boolean invokeZ(MemorySegment paramMemorySegment, boolean paramBoolean);
  
  boolean invokeZ(MemorySegment paramMemorySegment, float paramFloat1, float paramFloat2);
  
  boolean invokeZ(MemorySegment paramMemorySegment, int paramInt, float paramFloat);
  
  boolean invokeZ(MemorySegment paramMemorySegment, int paramInt1, int paramInt2);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  boolean invokeJZ(MemorySegment paramMemorySegment, long paramLong, int paramInt);
  
  boolean invokePZ(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, boolean paramBoolean);
  
  boolean invokeJZ(MemorySegment paramMemorySegment, long paramLong, int paramInt1, int paramInt2);
  
  boolean invokePZ(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong);
  
  boolean invokePZ(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong, float paramFloat);
  
  boolean invokePZ(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong, int paramInt2);
  
  boolean invokePZ(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong, boolean paramBoolean);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, float paramFloat2);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat, int paramInt);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, boolean paramBoolean);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, boolean paramBoolean, int paramInt);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  boolean invokePZ(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, float paramFloat, boolean paramBoolean, @FFMNullable @FFMPointer long paramLong);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  boolean invokePZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3);
  
  boolean invokePBZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte);
  
  boolean invokePCZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort);
  
  boolean invokePJZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  boolean invokePSZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort);
  
  boolean invokePUZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte);
  
  boolean invokeUPZ(MemorySegment paramMemorySegment, byte paramByte, @FFMNullable @FFMPointer long paramLong);
  
  boolean invokeJPZ(MemorySegment paramMemorySegment, long paramLong1, @FFMNullable @FFMPointer long paramLong2, boolean paramBoolean);
  
  boolean invokePJZ(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, boolean paramBoolean);
  
  boolean invokePSZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, short paramShort);
  
  boolean invokePUZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, byte paramByte);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, float paramFloat1, float paramFloat2, @FFMNullable @FFMPointer long paramLong2);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, boolean paramBoolean, @FFMNullable @FFMPointer long paramLong2, int paramInt);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, float paramFloat);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong1, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong2, int paramInt6);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong1, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong2, int paramInt6, boolean paramBoolean);
  
  boolean invokePPZ(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong1, int paramInt6, int paramInt7, int paramInt8, int paramInt9, @FFMNullable @FFMPointer long paramLong2, int paramInt10);
  
  boolean invokePCCZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, short paramShort2);
  
  boolean invokePPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  boolean invokePCCZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort1, short paramShort2, int paramInt);
  
  boolean invokePJJZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2, long paramLong3);
  
  boolean invokePJPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt);
  
  boolean invokePPPZ(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  boolean invokePPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  boolean invokePPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt);
  
  boolean invokePPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, boolean paramBoolean);
  
  boolean invokePPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, boolean paramBoolean, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  boolean invokePSSZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, short paramShort1, short paramShort2);
  
  boolean invokeCCJZ(MemorySegment paramMemorySegment, short paramShort1, boolean paramBoolean, short paramShort2, int paramInt, long paramLong);
  
  boolean invokePJPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2);
  
  boolean invokePPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, float paramFloat1, float paramFloat2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  boolean invokePPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, boolean paramBoolean, int paramInt);
  
  boolean invokePPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2, boolean paramBoolean);
  
  boolean invokePPPJZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4);
  
  boolean invokePPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  boolean invokePUUUZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte1, byte paramByte2, byte paramByte3);
  
  boolean invokePPPPZ(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  boolean invokePPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  boolean invokePPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  boolean invokePPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, float paramFloat, @FFMNullable @FFMPointer long paramLong4);
  
  boolean invokePPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt);
  
  boolean invokePPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, boolean paramBoolean, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  boolean invokePJPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  boolean invokePPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, float paramFloat, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  boolean invokePPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, @FFMNullable @FFMPointer long paramLong4, int paramInt2);
  
  boolean invokePPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, @FFMNullable @FFMPointer long paramLong4);
  
  boolean invokePPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  boolean invokePPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, @FFMNullable @FFMPointer long paramLong4, float paramFloat6);
  
  boolean invokePPPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  boolean invokePPPUPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, byte paramByte, @FFMNullable @FFMPointer long paramLong4);
  
  boolean invokePUUUUZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4);
  
  boolean invokePPPPPZ(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  boolean invokePPPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  boolean invokePPPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt);
  
  boolean invokePPPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  boolean invokePPPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, double paramDouble, @FFMNullable @FFMPointer long paramLong5, int paramInt);
  
  boolean invokePPPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, boolean paramBoolean, int paramInt);
  
  boolean invokePUUUUZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4);
  
  boolean invokePPPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, @FFMNullable @FFMPointer long paramLong4, int paramInt2, @FFMNullable @FFMPointer long paramLong5, int paramInt3);
  
  boolean invokePPJJPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  boolean invokePPPPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  boolean invokePPPPPPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, @FFMNullable @FFMPointer long paramLong4, int paramInt2, @FFMNullable @FFMPointer long paramLong5, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong6, int paramInt5, int paramInt6);
  
  short callC(MemorySegment paramMemorySegment, int paramInt);
  
  float callF(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3);
  
  float callPF(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat);
  
  int callI(MemorySegment paramMemorySegment);
  
  int callI(MemorySegment paramMemorySegment, int paramInt);
  
  int callI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2);
  
  int callI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  int callPI(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  int callPI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong);
  
  int callPI(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong, int paramInt2);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, float paramFloat2);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat, int paramInt);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, float paramFloat);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2);
  
  int callJI(MemorySegment paramMemorySegment, int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  int callPI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, float paramFloat1, float paramFloat2);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, boolean paramBoolean);
  
  int callPI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  int callPI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong);
  
  int callPI(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong, int paramInt2, int paramInt3, float paramFloat, int paramInt4);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  int callPI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat);
  
  int callPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8);
  
  int callPJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  int callPJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2);
  
  int callPJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, float paramFloat);
  
  int callPJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt);
  
  int callPPI(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, float paramFloat, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, float paramFloat);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt);
  
  int callPPI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, float paramFloat, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, float paramFloat1, float paramFloat2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, float paramFloat, int paramInt);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, float paramFloat1, float paramFloat2, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, int paramInt3);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean);
  
  int callPPI(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, int paramInt2, int paramInt3, float paramFloat, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt2, @FFMNullable @FFMPointer long paramLong2);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt3, @FFMNullable @FFMPointer long paramLong2, int paramInt4);
  
  int callPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, @FFMNullable @FFMPointer long paramLong2, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15);
  
  int callPJJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3);
  
  int callPJPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int callPPJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int callPJJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, float paramFloat);
  
  int callPJJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, int paramInt);
  
  int callPJPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int callPJPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3);
  
  int callPPJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, long paramLong3);
  
  int callPPJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, long paramLong3);
  
  int callPPNI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt);
  
  int callPJJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2);
  
  int callPJPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2);
  
  int callPPJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, int paramInt3, @FFMNullable @FFMPointer long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2, int paramInt3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2, int paramInt3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2, int paramInt3, int paramInt4);
  
  int callPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong3);
  
  int callJPPI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  int callJJPPI(MemorySegment paramMemorySegment, long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPJJJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  int callPJJPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPJPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPJPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPNPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPJJJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
  
  int callPJPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt);
  
  int callPJPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt2);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, @FFMNullable @FFMPointer long paramLong4, int paramInt2);
  
  int callPJPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPPPPI(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, int paramInt18, int paramInt19, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  int callPJJPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPJPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPPJPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPJJJPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, @FFMNullable @FFMPointer long paramLong5);
  
  int callPJPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt, @FFMNullable @FFMPointer long paramLong5);
  
  int callPPJPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPPJPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPPPPPI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callJPPPPI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt3, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPJPPJI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, long paramLong5, int paramInt3);
  
  int callPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3, int paramInt3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  int callPJJJJPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int callPPPPJPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int callPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int callPJJPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int callPJPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int callPPPJPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4, int paramInt, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int callPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int callPJPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt2, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int callPPPJPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4, int paramInt2, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int callPPPPPPI(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int callPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int callPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt2, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  int callPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  int callPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  int callPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  int callPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, int paramInt);
  
  int callPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  int callPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  int callPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt2, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  int callPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt2, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  int callPPPPPJPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8);
  
  int callPPJPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8);
  
  int callPPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, int paramInt, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8);
  
  int callPPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, int paramInt2, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8);
  
  int callPPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt3, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8);
  
  int callPPPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, int paramInt, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9);
  
  int callPPPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, int paramInt2, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9);
  
  int callPPPPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, int paramInt, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10);
  
  int callPPPPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt1, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, int paramInt2, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10);
  
  int callPPPPPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, int paramInt, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10, @FFMNullable @FFMPointer long paramLong11);
  
  int callPPPPPPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10, int paramInt, @FFMNullable @FFMPointer long paramLong11, @FFMNullable @FFMPointer long paramLong12);
  
  int callPPPPPPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10, int paramInt2, @FFMNullable @FFMPointer long paramLong11, @FFMNullable @FFMPointer long paramLong12);
  
  int callPPPPPPPPPPPPPPPI(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10, @FFMNullable @FFMPointer long paramLong11, @FFMNullable @FFMPointer long paramLong12, int paramInt, @FFMNullable @FFMPointer long paramLong13, @FFMNullable @FFMPointer long paramLong14, @FFMNullable @FFMPointer long paramLong15);
  
  long callJ(MemorySegment paramMemorySegment);
  
  long callJ(MemorySegment paramMemorySegment, int paramInt);
  
  long callJ(MemorySegment paramMemorySegment, int paramInt1, int paramInt2);
  
  long callJ(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4);
  
  long callPJ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  long callPPJ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  long callPJJ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  long callPJJJ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3);
  
  long callPN(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  @FFMPointer
  long callP(MemorySegment paramMemorySegment);
  
  @FFMPointer
  long callP(MemorySegment paramMemorySegment, int paramInt);
  
  @FFMPointer
  long callP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2);
  
  @FFMPointer
  long callP(MemorySegment paramMemorySegment, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  
  @FFMPointer
  long callJP(MemorySegment paramMemorySegment, long paramLong);
  
  @FFMPointer
  long callPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  @FFMPointer
  long callPP(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong);
  
  @FFMPointer
  long callPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  @FFMPointer
  long callPP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong);
  
  @FFMPointer
  long callPP(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong, int paramInt2);
  
  @FFMPointer
  long callPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2);
  
  @FFMPointer
  long callPP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong, int paramInt3);
  
  @FFMPointer
  long callJJP(MemorySegment paramMemorySegment, long paramLong1, long paramLong2);
  
  @FFMPointer
  long callPNP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  @FFMPointer
  long callPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long callPPP(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long callPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long callPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt);
  
  @FFMPointer
  long callPPP(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt2);
  
  @FFMPointer
  long callPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long callPPP(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long callPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong2);
  
  @FFMPointer
  long callPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3);
  
  @FFMPointer
  long callPPNP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3);
  
  @FFMPointer
  long callPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long callPJPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long callPJPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt);
  
  @FFMPointer
  long callPPPP(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long callPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long callPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long callPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt);
  
  @FFMPointer
  long callPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long callPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2);
  
  @FFMPointer
  long callPJPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong3);
  
  @FFMPointer
  long callJJPPP(MemorySegment paramMemorySegment, long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long callPPJPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long callPPNPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long callPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long callPJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long callPJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long callPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long callPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long callPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long callPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt);
  
  @FFMPointer
  long callPJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  @FFMPointer
  long callPJPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long callPPPJPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long callPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long callPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long callPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, int paramInt3, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  @FFMPointer
  long callPJJPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  @FFMPointer
  long callPJPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  @FFMPointer
  long callPPJPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  @FFMPointer
  long callPPPJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  @FFMPointer
  long callPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  @FFMPointer
  long callPPJPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  @FFMPointer
  long callPPPPJPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  @FFMPointer
  long callPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  @FFMPointer
  long callPPPPPPPP(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt6, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  @FFMPointer
  long callPJPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8);
  
  @FFMPointer
  long callPPJPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt2, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8);
  
  @FFMPointer
  long callPJPPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10);
  
  @FFMPointer
  long callPPJPPPPPPPP(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, int paramInt2, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9, @FFMNullable @FFMPointer long paramLong10);
  
  short callS(MemorySegment paramMemorySegment, int paramInt);
  
  short callPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  short callPCS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort);
  
  short callPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  short callPSS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, short paramShort);
  
  short callSPS(MemorySegment paramMemorySegment, short paramShort, @FFMNullable @FFMPointer long paramLong);
  
  short callPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt);
  
  short callPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2);
  
  short callPCPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort, @FFMNullable @FFMPointer long paramLong2);
  
  short callPPCS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, short paramShort);
  
  short callPPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  short callPPSS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, short paramShort);
  
  short callPSPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort, @FFMNullable @FFMPointer long paramLong2);
  
  short callSPPS(MemorySegment paramMemorySegment, short paramShort, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  short callSPSS(MemorySegment paramMemorySegment, short paramShort1, @FFMNullable @FFMPointer long paramLong, short paramShort2);
  
  short callPPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3);
  
  short callPJCCS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, short paramShort1, short paramShort2);
  
  short callPPSPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, short paramShort, @FFMNullable @FFMPointer long paramLong3);
  
  short callPSSPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, short paramShort2, @FFMNullable @FFMPointer long paramLong2, int paramInt);
  
  short callPPPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4);
  
  short callPCPPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  short callPCPSPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, @FFMNullable @FFMPointer long paramLong2, short paramShort2, @FFMNullable @FFMPointer long paramLong3);
  
  short callPSSPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, short paramShort2, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3);
  
  short callPCPPPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  short callPCSPPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, short paramShort2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  short callPPSPSPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, short paramShort1, @FFMNullable @FFMPointer long paramLong3, short paramShort2, @FFMNullable @FFMPointer long paramLong4);
  
  short callPCCPSPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, short paramShort2, @FFMNullable @FFMPointer long paramLong2, short paramShort3, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  short callPPSPSPSS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, short paramShort1, @FFMNullable @FFMPointer long paramLong3, short paramShort2, @FFMNullable @FFMPointer long paramLong4, short paramShort3);
  
  short callSPSSPSPS(MemorySegment paramMemorySegment, short paramShort1, @FFMNullable @FFMPointer long paramLong1, short paramShort2, short paramShort3, @FFMNullable @FFMPointer long paramLong2, short paramShort4, @FFMNullable @FFMPointer long paramLong3);
  
  short callPCPSPPSPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, @FFMNullable @FFMPointer long paramLong2, short paramShort2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, short paramShort3, @FFMNullable @FFMPointer long paramLong5);
  
  short callPPPSPSPCS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, short paramShort1, @FFMNullable @FFMPointer long paramLong4, short paramShort2, @FFMNullable @FFMPointer long paramLong5, short paramShort3);
  
  short callSPSPPPSPS(MemorySegment paramMemorySegment, short paramShort1, @FFMNullable @FFMPointer long paramLong1, short paramShort2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, short paramShort3, @FFMNullable @FFMPointer long paramLong5);
  
  short callPCPSPPPPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, @FFMNullable @FFMPointer long paramLong2, short paramShort2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  short callPPSPSPSCCS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, short paramShort1, @FFMNullable @FFMPointer long paramLong3, short paramShort2, @FFMNullable @FFMPointer long paramLong4, short paramShort3, short paramShort4, short paramShort5);
  
  short callPPSPSPSPSS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, short paramShort1, @FFMNullable @FFMPointer long paramLong3, short paramShort2, @FFMNullable @FFMPointer long paramLong4, short paramShort3, @FFMNullable @FFMPointer long paramLong5, short paramShort4);
  
  short callPCPSPSPSCCS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, @FFMNullable @FFMPointer long paramLong2, short paramShort2, @FFMNullable @FFMPointer long paramLong3, short paramShort3, @FFMNullable @FFMPointer long paramLong4, short paramShort4, short paramShort5, short paramShort6);
  
  short callPCSSSPSPPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, short paramShort2, short paramShort3, short paramShort4, @FFMNullable @FFMPointer long paramLong2, short paramShort5, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  short callPSSSPSSPPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, short paramShort2, short paramShort3, @FFMNullable @FFMPointer long paramLong2, short paramShort4, short paramShort5, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  short callPSPSPPPPPPPS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, short paramShort1, @FFMNullable @FFMPointer long paramLong2, short paramShort2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7, @FFMNullable @FFMPointer long paramLong8, @FFMNullable @FFMPointer long paramLong9);
  
  short callPPSPSPSPSPSPSS(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, short paramShort1, @FFMNullable @FFMPointer long paramLong3, short paramShort2, @FFMNullable @FFMPointer long paramLong4, short paramShort3, @FFMNullable @FFMPointer long paramLong5, short paramShort4, @FFMNullable @FFMPointer long paramLong6, short paramShort5, @FFMNullable @FFMPointer long paramLong7, short paramShort6);
  
  void callV(MemorySegment paramMemorySegment);
  
  void callV(MemorySegment paramMemorySegment, double paramDouble);
  
  void callV(MemorySegment paramMemorySegment, float paramFloat);
  
  void callV(MemorySegment paramMemorySegment, int paramInt);
  
  void callV(MemorySegment paramMemorySegment, boolean paramBoolean);
  
  void callV(MemorySegment paramMemorySegment, double paramDouble1, double paramDouble2);
  
  void callV(MemorySegment paramMemorySegment, float paramFloat1, float paramFloat2);
  
  void callV(MemorySegment paramMemorySegment, float paramFloat, boolean paramBoolean);
  
  void callV(MemorySegment paramMemorySegment, int paramInt, double paramDouble);
  
  void callV(MemorySegment paramMemorySegment, int paramInt, float paramFloat);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2);
  
  void callV(MemorySegment paramMemorySegment, int paramInt, boolean paramBoolean);
  
  void callV(MemorySegment paramMemorySegment, double paramDouble1, double paramDouble2, double paramDouble3);
  
  void callV(MemorySegment paramMemorySegment, float paramFloat1, float paramFloat2, float paramFloat3);
  
  void callV(MemorySegment paramMemorySegment, int paramInt, double paramDouble1, double paramDouble2);
  
  void callV(MemorySegment paramMemorySegment, int paramInt, float paramFloat1, float paramFloat2);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, double paramDouble);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, float paramFloat);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, boolean paramBoolean);
  
  void callV(MemorySegment paramMemorySegment, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
  
  void callV(MemorySegment paramMemorySegment, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3);
  
  void callV(MemorySegment paramMemorySegment, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, float paramFloat, int paramInt3);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, double paramDouble);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, float paramFloat);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3);
  
  void callV(MemorySegment paramMemorySegment, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  void callV(MemorySegment paramMemorySegment, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, double paramDouble3, double paramDouble4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, float paramFloat3, float paramFloat4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5);
  
  void callV(MemorySegment paramMemorySegment, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6);
  
  void callV(MemorySegment paramMemorySegment, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15);
  
  void callV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17);
  
  void callJV(MemorySegment paramMemorySegment, long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  void callSV(MemorySegment paramMemorySegment, short paramShort);
  
  void callUV(MemorySegment paramMemorySegment, byte paramByte);
  
  void callCV(MemorySegment paramMemorySegment, int paramInt, short paramShort);
  
  void callJV(MemorySegment paramMemorySegment, int paramInt, long paramLong);
  
  void callJV(MemorySegment paramMemorySegment, long paramLong, int paramInt);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat);
  
  void callPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt);
  
  void callSV(MemorySegment paramMemorySegment, int paramInt, short paramShort);
  
  void callJV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong, int paramInt2);
  
  void callPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, float paramFloat2);
  
  void callPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2);
  
  void callJV(MemorySegment paramMemorySegment, int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  void callNV(MemorySegment paramMemorySegment, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong, int paramInt3);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, boolean paramBoolean, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong, int paramInt2, int paramInt3);
  
  void callPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  void callPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong, int paramInt4);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong, boolean paramBoolean);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong, int paramInt3, int paramInt4);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  void callJV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong, boolean paramBoolean);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong, int paramInt4, int paramInt5);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong, int paramInt3, int paramInt4, int paramInt5);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  void callJV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong, int paramInt6);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong, int paramInt4, int paramInt5, int paramInt6);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  void callPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  void callJV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
  
  void callJV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6, long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6, @FFMNullable @FFMPointer long paramLong);
  
  void callJV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7, long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, int paramInt3, double paramDouble3, double paramDouble4, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, @FFMNullable @FFMPointer long paramLong);
  
  void callJV(MemorySegment paramMemorySegment, long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, @FFMNullable @FFMPointer long paramLong);
  
  void callPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  void callJV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong, boolean paramBoolean);
  
  void callPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, @FFMNullable @FFMPointer long paramLong);
  
  void callPJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void callSSV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2);
  
  void callJJV(MemorySegment paramMemorySegment, int paramInt, long paramLong1, long paramLong2);
  
  void callPCV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong, int paramInt, short paramShort);
  
  void callPJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2);
  
  void callPJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, float paramFloat);
  
  void callPJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt);
  
  void callSSV(MemorySegment paramMemorySegment, int paramInt, short paramShort1, short paramShort2);
  
  void callJJV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  void callJPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void callJPV(MemorySegment paramMemorySegment, int paramInt1, long paramLong1, int paramInt2, @FFMNullable @FFMPointer long paramLong2);
  
  void callPJV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, int paramInt2, long paramLong2);
  
  void callPJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, long paramLong2, int paramInt2);
  
  void callPJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, int paramInt2, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, boolean paramBoolean);
  
  void callPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2);
  
  void callPJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, int paramInt3, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt3);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, int paramInt3);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, int paramInt3);
  
  void callPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt3, int paramInt4);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, int paramInt3, int paramInt4);
  
  void callPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, int paramInt3, int paramInt4);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong1, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt3, int paramInt4, int paramInt5);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong1, int paramInt5, int paramInt6, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong1, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, @FFMNullable @FFMPointer long paramLong2);
  
  void callPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong2, int paramInt6, int paramInt7, float paramFloat);
  
  void callBBBV(MemorySegment paramMemorySegment, byte paramByte1, byte paramByte2, byte paramByte3);
  
  void callCCCV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3);
  
  void callPJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3);
  
  void callPJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPNV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void callSSSV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3);
  
  void callUUUV(MemorySegment paramMemorySegment, byte paramByte1, byte paramByte2, byte paramByte3);
  
  void callJJJV(MemorySegment paramMemorySegment, int paramInt, long paramLong1, long paramLong2, long paramLong3);
  
  void callPJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, int paramInt);
  
  void callPJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt);
  
  void callSSSV(MemorySegment paramMemorySegment, int paramInt, short paramShort1, short paramShort2, short paramShort3);
  
  void callJJJV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
  
  void callPJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
  
  void callPJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2);
  
  void callPPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt2);
  
  void callPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong3);
  
  void callPJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPJV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, long paramLong3, boolean paramBoolean);
  
  void callPPJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, long paramLong3, int paramInt3);
  
  void callPPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, int paramInt3, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, int paramInt3, @FFMNullable @FFMPointer long paramLong3);
  
  void callPJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, int paramInt3, int paramInt4);
  
  void callPPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong1, int paramInt5, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3);
  
  void callPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, @FFMNullable @FFMPointer long paramLong3, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15);
  
  void callBBBBV(MemorySegment paramMemorySegment, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4);
  
  void callCCCCV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3, short paramShort4);
  
  void callPJJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  void callPJJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void callPJPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void callPPPNV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, long paramLong4);
  
  void callPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void callSSSSV(MemorySegment paramMemorySegment, short paramShort1, short paramShort2, short paramShort3, short paramShort4);
  
  void callUUUUV(MemorySegment paramMemorySegment, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4);
  
  void callJJJJV(MemorySegment paramMemorySegment, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  void callPJJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);
  
  void callPJJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, long paramLong2, long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void callPJJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, int paramInt, @FFMNullable @FFMPointer long paramLong4);
  
  void callPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void callPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt);
  
  void callSSSSV(MemorySegment paramMemorySegment, int paramInt, short paramShort1, short paramShort2, short paramShort3, short paramShort4);
  
  void callUUUUV(MemorySegment paramMemorySegment, int paramInt, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4);
  
  void callJJJJV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  void callPJJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2);
  
  void callPJJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4);
  
  void callPJJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong4);
  
  void callPJPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, @FFMNullable @FFMPointer long paramLong3, int paramInt2, @FFMNullable @FFMPointer long paramLong4);
  
  void callPPPPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void callPPPPV(MemorySegment paramMemorySegment, int paramInt1, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt2);
  
  void callPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void callPJJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int paramInt3, @FFMNullable @FFMPointer long paramLong4);
  
  void callPJJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong4);
  
  void callPJPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void callPPPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
  
  void callPPPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, int paramInt3);
  
  void callPJJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong4, int paramInt4);
  
  void callPJPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong3, int paramInt4, @FFMNullable @FFMPointer long paramLong4);
  
  void callPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong2, int paramInt5, @FFMNullable @FFMPointer long paramLong3, int paramInt6, @FFMNullable @FFMPointer long paramLong4);
  
  void callPJJJPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  void callPPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  void callPJJJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, int paramInt2);
  
  void callPPPPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  void callPPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  void callPJJJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4, long paramLong5, int paramInt3);
  
  void callPJPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, int paramInt2, long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5);
  
  void callPPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, int paramInt1, int paramInt2, int paramInt3);
  
  void callPPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, int paramInt1, @FFMNullable @FFMPointer long paramLong2, int paramInt2, int paramInt3, int paramInt4, @FFMNullable @FFMPointer long paramLong3, int paramInt5, @FFMNullable @FFMPointer long paramLong4, int paramInt6, @FFMNullable @FFMPointer long paramLong5);
  
  void callPPPPPJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, long paramLong6);
  
  void callPPPPPPV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, int paramInt1, int paramInt2, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6);
  
  void callPPPPPPPV(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, @FFMNullable @FFMPointer long paramLong1, int paramInt4, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4, @FFMNullable @FFMPointer long paramLong5, @FFMNullable @FFMPointer long paramLong6, @FFMNullable @FFMPointer long paramLong7);
  
  void callPPJJJJJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
  
  void callPJJJJJJJJJJJV(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, int paramInt1, int paramInt2, int paramInt3);
  
  boolean callZ(MemorySegment paramMemorySegment, int paramInt);
  
  boolean callZ(MemorySegment paramMemorySegment, int paramInt1, int paramInt2);
  
  boolean callZ(MemorySegment paramMemorySegment, int paramInt, float paramFloat1, float paramFloat2);
  
  boolean callZ(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  
  boolean callJZ(MemorySegment paramMemorySegment, long paramLong);
  
  boolean callPZ(MemorySegment paramMemorySegment, @FFMNullable @FFMPointer long paramLong);
  
  boolean callJZ(MemorySegment paramMemorySegment, int paramInt, long paramLong);
  
  boolean callPZ(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong);
  
  boolean callJZ(MemorySegment paramMemorySegment, int paramInt1, long paramLong, int paramInt2);
  
  boolean callPPZ(MemorySegment paramMemorySegment, int paramInt, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2);
  
  boolean callPPPPZ(MemorySegment paramMemorySegment, int paramInt1, int paramInt2, int paramInt3, float paramFloat, @FFMNullable @FFMPointer long paramLong1, @FFMNullable @FFMPointer long paramLong2, @FFMNullable @FFMPointer long paramLong3, @FFMNullable @FFMPointer long paramLong4);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\JNI$JNIBindings.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */